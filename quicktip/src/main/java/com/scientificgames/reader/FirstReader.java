package com.scientificgames.reader;

import java.io.File;

import com.scientificgames.model.Parameters;

public class FirstReader extends XmlReader<Parameters> {
    public FirstReader(Class<Parameters> classType) {
        super(classType);
    }

    @Override
    File getFile() {
        return new File(getClass().getClassLoader().getResource("first_param.xml").getFile());
    }
}
