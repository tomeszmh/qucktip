package com.scientificgames.reader;

import java.io.File;

import com.scientificgames.model.Parameters;

public class SecondReader extends AbstractXmlReader<Parameters> {
    private static final String XML_FILE_NAME = "second_param.xml";

    public SecondReader(Class<Parameters> classType) {
        super(classType);
    }

    @Override
    File getFile() {
        return new File(getClass().getClassLoader().getResource(XML_FILE_NAME).getFile());
    }
}
