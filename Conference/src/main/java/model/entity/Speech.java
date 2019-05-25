package model.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Speech {
    private long id;
    private Speaker speaker;
    private String theme;
    private Date date;

    public Speech(Builder builder) {
        this.id = builder.id;
        this.speaker = builder.speaker;
        this.theme = builder.theme;
        this.date = builder.date;
    }

    public static class Builder{
        private long id;
        private Speaker speaker;
        private String theme;
        private Date date;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setSpeaker(Speaker speeker) {
            this.speaker = speeker;
            return this;
        }

        public Builder setTheme(String theme) {
            this.theme = theme;
            return this;
        }

        public Builder setDate(Date date) {
            this.date = date;
            return this;
        }

        public Speech build(){
            return new Speech(this);
        }
    }
}
