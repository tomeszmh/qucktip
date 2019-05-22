package com.scientificgames.reader;

import java.io.IOException;
import java.io.Serializable;

import com.scientificgames.model.Parameters;

@FunctionalInterface
public interface ParameterReadable<P extends Parameters> extends Serializable {
    P readParams() throws IOException;
}
