package com.scientificgames.reader;

import java.io.*;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.scientificgames.model.Parameters;

public abstract class AbstractXmlReader<P extends Parameters> implements ParameterReadable {
    private Class<P> classType;

    public AbstractXmlReader(Class<P> classType) {
        this.classType = classType;
    }

    abstract File getFile();

    public P readParams() {
        try {
            File file = getFile();
            String xml = inputStreamToString(new FileInputStream(file));
            XmlMapper mapper = new XmlMapper();
            return mapper.readValue(xml, classType);
        } catch (JsonMappingException e) {
            System.err.println("Unable to map xml file to " + classType.getName());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Unable to read input xml file");
            e.printStackTrace();
        }
        return null;
    }

    private String inputStreamToString(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}
