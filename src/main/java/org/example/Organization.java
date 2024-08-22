package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Organization {
    private Data data;

    public static class Data {
        private String inn;
        private String kpp;
        private String ogrn;

        @JsonProperty("name")
        private Name name;

        public static class Name {
            @JsonProperty("full_with_opf")
            private String fullName;

            public String getFullName() {
                return fullName;
            }

            public void setFullName(String fullName) {
                this.fullName = fullName;
            }
        }

        public String getInn() {
            return inn;
        }

        public void setInn(String inn) {
            this.inn = inn;
        }

        public String getKpp() {
            return kpp;
        }

        public void setKpp(String kpp) {
            this.kpp = kpp;
        }

        public String getOgrn() {
            return ogrn;
        }

        public void setOgrn(String ogrn) {
            this.ogrn = ogrn;
        }

        public Name getName() {
            return name;
        }

        public void setName(Name name) {
            this.name = name;
        }
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
