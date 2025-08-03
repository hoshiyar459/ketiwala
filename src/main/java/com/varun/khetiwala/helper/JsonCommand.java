package com.varun.khetiwala.helper;

import com.fasterxml.jackson.databind.JsonNode;

public class JsonCommand {

    private final JsonNode requestJson;

    public JsonCommand(JsonNode requestJson) {
        this.requestJson = requestJson;
    }

    public boolean isChangeInStringParameterNamed(String paramName, String existingValue) {
        if (requestJson.has(paramName)) {
            String newValue = requestJson.get(paramName).asText();
            return !newValue.equals(existingValue);
        }
        return false;
    }

    public String stringValueOfParameterNamed(String paramName) {
        return requestJson.has(paramName) ? requestJson.get(paramName).asText() : null;
    }
}

