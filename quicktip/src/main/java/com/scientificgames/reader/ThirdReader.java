package com.scientificgames.reader;


import java.io.File;

import com.scientificgames.model.Parameters;

public class ThirdReader extends AbstractXmlReader<Parameters> {
    private static final String XML_FILE_NAME = "third_param.xml";

    public ThirdReader(Class<Parameters> classType) {
        super(classType);
    }

    @Override
    File getFile() {
        return new File(getClass().getClassLoader().getResource(XML_FILE_NAME).getFile());
    }
}
