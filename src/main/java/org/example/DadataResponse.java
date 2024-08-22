package org.example;

import java.util.List;

public class DadataResponse {
    private List<Organization> suggestions;

    public List<Organization> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<Organization> suggestions) {
        this.suggestions = suggestions;
    }
}
