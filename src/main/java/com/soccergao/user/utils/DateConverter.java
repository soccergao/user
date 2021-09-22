package com.soccergao.user.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 基础时间转换类Java8版本
 * LocalDateTime to Date
 * LocalDate to Date
 * Date to LocalDateTime
 * Date to LocalDate
 */
public class DateConverter {
    /**
     * LocalDateTime转换成Date
     * an alternative solution is using an Instant object, which we obtain from ZonedDateTime
     * @param dateToConvert
     * @return
     */
    public static Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * LocalDateTime转换成Date
     * The easiest way of getting a java.util.Date from LocalDateTime is to use an extension to the java.sql.Timestamp — available with Java 8
     * @param dateToConvert
     * @return
     */
    public static Date convertToDateViaSqlTimestamp(LocalDateTime dateToConvert) {
        return java.sql.Timestamp.valueOf(dateToConvert);
    }

    /**
     * LocalDate转换成Date
     * use an Instant object that we pass to the from(Instant instant) method of java.util.Date object
     * @param dateToConvert
     * @return
     */
    public static Date convertToDateViaInstant(LocalDate dateToConvert) {
        return Date.from(dateToConvert.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * LocalDate转换成Date
     * use a new valueOf(LocalDate date) method provided in java.sql.Date object
     * @param dateToConvert
     * @return
     */
    public static Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }

    /**
     * Date转换成LocalDateTime
     * using the default system ZoneId
     * @param dateToConvert
     * @return
     */
    public static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * Date转换成LocalDateTime
     * using the ofEpochMilli() method
     * @param dateToConvert
     * @return
     */
    public static LocalDateTime convertToLocalDateTimeViaMillisecond(Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * Date转换成LocalDateTime
     * use java.sql.Timestamp to obtain a LocalDateTime
     * @param dateToConvert
     * @return
     */
    public static LocalDateTime convertToLocalDateTimeViaSqlTimestamp(Date dateToConvert) {
        return new java.sql.Timestamp(dateToConvert.getTime()).toLocalDateTime();
    }

    /**
     * Date转换成LocalDate
     * an additional toLocalDate() method on java.sql.Date
     * @param dateToConvert
     * @return
     */
    public static LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }

    /**
     * Date转换成LocalDate
     * using the default system ZoneId
     * @param dateToConvert
     * @return
     */
    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * Date转换成LocalDate
     * using the ofEpochMilli() method
     * @param dateToConvert
     * @return
     */
    public static LocalDate convertToLocalDateViaMillisecond(Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
