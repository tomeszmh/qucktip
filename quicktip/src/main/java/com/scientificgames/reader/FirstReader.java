package com.scientificgames.reader;

import java.io.File;

import com.scientificgames.model.Parameters;

public class FirstReader extends AbstractXmlReader<Parameters> {
    private static final int DEAFAULT_PANEL_COUNT = 1;
    private static final String XML_FILE_NAME = "first_param.xml";

    public FirstReader(Class<Parameters> classType) {
        super(classType);
    }

    @Override
    public Parameters readParams() {
        Parameters params = super.readParams();
        params.setPanelCount(DEAFAULT_PANEL_COUNT);
        return params;
    }

    @Override
    File getFile() {
        return new File(getClass().getClassLoader().getResource(XML_FILE_NAME).getFile());
    }
}
