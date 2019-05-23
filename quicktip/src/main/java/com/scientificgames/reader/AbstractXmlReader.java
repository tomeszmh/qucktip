package com.scientificgames.reader;

import java.io.*;
import java.util.function.UnaryOperator;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.scientificgames.model.Parameters;

public abstract class AbstractXmlReader<P extends Parameters> implements ParameterReadable {
    private Class<P> classType;

    public AbstractXmlReader(Class<P> classType) {
        this.classType = classType;
    }

    abstract InputStream getFileAsInputStream();

    protected UnaryOperator<P> getParamCustomizer() {
        return p -> p;
    }

    public P readParams() {
        try {
            return getParamCustomizer().apply(new XmlMapper().readValue(getFileAsInputStream(), classType));
        } catch (JsonMappingException e) {
            throw new RuntimeException("Unable to map xml file to " + classType.getName(), e);
        } catch (IOException e) {
            throw new RuntimeException("Unable to read input xml file", e);
        }
    }

}
