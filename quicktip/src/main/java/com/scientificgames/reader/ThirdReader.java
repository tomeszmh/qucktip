package com.scientificgames.reader;


import java.io.File;
import java.io.InputStream;

import com.scientificgames.model.Parameters;

public class ThirdReader extends AbstractXmlReader<Parameters> {
    private static final String XML_FILE_NAME = "third_param.xml";

    public ThirdReader(Class<Parameters> classType) {
        super(classType);
    }

    @Override
    InputStream getFileAsInputStream() {
        return  getClass().getClassLoader().getResourceAsStream(XML_FILE_NAME);
    }
}
