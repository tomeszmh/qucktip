package com.scientificgames.reader;

import java.io.InputStream;
import java.util.function.UnaryOperator;

import com.scientificgames.model.Parameters;

public class FirstReader extends AbstractXmlReader<Parameters> {
    private static final int DEFAULT_PANEL_COUNT = 1;
    private static final String XML_FILE_NAME = "first_param.xml";

    public FirstReader(Class<Parameters> classType) {
        super(classType);
    }

    @Override
    protected UnaryOperator<Parameters> getParamCustomizer() {
        return p -> p.setPanelCount(DEFAULT_PANEL_COUNT);
    }

    @Override
    InputStream getFileAsInputStream() {
        return getClass().getClassLoader().getResourceAsStream(XML_FILE_NAME);
    }
}
