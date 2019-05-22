package com.scientificgames.reader;

import java.io.File;
import java.util.function.Function;

import com.scientificgames.model.Parameters;

public class SecondReader extends AbstractXmlReader<Parameters> {
    private static final String XML_FILE_NAME = "second_param.xml";
    private static final int DEAFAULT_MAX_NUMBER = 90;

    public SecondReader(Class<Parameters> classType) {
        super(classType);
    }

    @Override
    Function<Parameters, Parameters> getParamCustomizer() {
        return (p) -> {
            p.setMaxNumber(DEAFAULT_MAX_NUMBER);
            return p;
        };
    }

    @Override
    File getFile() {
        return new File(getClass().getClassLoader().getResource(XML_FILE_NAME).getFile());
    }
}
