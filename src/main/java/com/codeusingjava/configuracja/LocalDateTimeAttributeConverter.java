package com.codeusingjava.configuracja;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Time;
import java.time.LocalTime;

@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalTime, Time> {

    @Override
    public Time convertToDatabaseColumn(LocalTime attribute) {
        return attribute == null ? null : Time.valueOf(attribute);
    }

    @Override
    public LocalTime convertToEntityAttribute(Time dbData) {
        return dbData == null ? null : dbData.toLocalTime();
    }
}
