package com.codeusingjava.configuracja;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class LocalDateAttributeConverterTest {

    private LocalDateAttributeConverter converter = new LocalDateAttributeConverter();

    @Test
    public void convert_to_database_column_test() {
        LocalDate localDate = LocalDate.of(2020, 1, 1);
        Date date = converter.convertToDatabaseColumn(localDate);
        assertNotNull(date);
        assertEquals(localDate, date.toLocalDate());
    }

    @Test
    public void convert_to_entity_attribute_test() {
        Date sqlDate = Date.valueOf(LocalDate.of(2020, 1, 1));
        LocalDate localDate = converter.convertToEntityAttribute(sqlDate);
        assertNotNull(localDate);
        assertEquals(sqlDate.toLocalDate(), localDate);
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