package com.codeusingjava.configuracja;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LocalDateTimeAttributeConverterTest {

    private LocalDateTimeAttributeConverter converter = new LocalDateTimeAttributeConverter();

    @Test
    void convert_to_database_column_test() {
        LocalTime localTime = LocalTime.of(10, 15);
        Time time = converter.convertToDatabaseColumn(localTime);
        assertNotNull(time);
        assertEquals(localTime, time.toLocalTime());
    }

    @Test
    void convert_to_entity_attribute_test() {
        Time time = Time.valueOf(LocalTime.of(10, 15));
        LocalTime localTime = converter.convertToEntityAttribute(time);
        assertNotNull(localTime);
        assertEquals(time.toLocalTime(), localTime);
    }

    @Test
    public void convert_to_database_column_with_null_input_test() {
        assertEquals(null, converter.convertToDatabaseColumn(null));
    }

    @Test
    public void convert_to_entity_attribute_with_null_input_test() {
        assertEquals(null, converter.convertToEntityAttribute(null));
    }
}

/*
    @Override
    public Time convertToDatabaseColumn(LocalTime attribute) {
        return attribute == null ? null : Time.valueOf(attribute);
    }

    @Override
    public LocalTime convertToEntityAttribute(Time dbData) {
        return dbData == null ? null : dbData.toLocalTime();
    }*/
