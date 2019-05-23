package com.scientificgames.reader;

import java.io.InputStream;
import java.util.function.UnaryOperator;

import com.scientificgames.model.Parameters;

public class SecondReader extends AbstractXmlReader<Parameters> {
    private static final String XML_FILE_NAME = "second_param.xml";
    private static final int DEFAULT_MAX_NUMBER = 90;

    public SecondReader(Class<Parameters> classType) {
        super(classType);
    }


    @Override
    protected UnaryOperator<Parameters> getParamCustomizer() {
        return p -> p.setMaxNumber(DEFAULT_MAX_NUMBER);
    }

    @Override
    InputStream getFileAsInputStream() {
        return  getClass().getClassLoader().getResourceAsStream(XML_FILE_NAME);
    }
}
