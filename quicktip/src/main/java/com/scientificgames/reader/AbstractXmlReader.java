package com.scientificgames.reader;

import java.io.File;
import java.io.IOException;
import java.util.function.Function;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.scientificgames.model.Parameters;

public abstract class AbstractXmlReader<P extends Parameters> implements ParameterReadable {
    private Class<P> classType;

    public AbstractXmlReader(Class<P> classType) {
        this.classType = classType;
    }

    abstract File getFile();

    Function<P, P> getParamCustomizer() {
        return p -> p;
    }

    public P readParams() {
        try {
            return getParamCustomizer().apply(new XmlMapper().readValue(getFile(), classType));
        } catch (JsonMappingException e) {
            throw new RuntimeException("Unable to map xml file to " + classType.getName(), e);
        } catch (IOException e) {
            throw new RuntimeException("Unable to read input xml file", e);
        }
    }

}
