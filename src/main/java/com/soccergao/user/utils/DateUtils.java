package com.soccergao.user.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;

/**
 * 时间工具类
 */
public class DateUtils {
    /**
     * Date转换成LocalDateTime
     * @param date
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        return dateToLocalDateTime(date, null);
    }

    /**
     * Date转换成LocalDateTime
     * @param date
     * @param defaultLocalDateTime
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date date, LocalDateTime defaultLocalDateTime) {
        return Objects.isNull(date) ? defaultLocalDateTime : DateConverter.convertToLocalDateTimeViaInstant(date);
    }

    /**
     * LocalDateTime转换成Date
     * @param localDateTime
     * @return
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return localDateTimeToDate(localDateTime, null);
    }

    /**
     * LocalDateTime转换成Date
     * @param localDateTime
     * @param defaultDate
     * @return
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime, Date defaultDate) {
        return Objects.isNull(localDateTime) ? defaultDate : DateConverter.convertToDateViaInstant(localDateTime);
    }

    /**
     * 获取到当天0点的时间（秒）
     *
     * @return
     */
    public static Long getSecondsCurrDay() {
        Date currDate = new Date();
        LocalDateTime midnight = LocalDateTime.ofInstant(currDate.toInstant(),
                ZoneId.systemDefault()).plusDays(1).withHour(0).withMinute(0)
                .withSecond(0).withNano(0);

        LocalDateTime currentDateTime = LocalDateTime.ofInstant(currDate.toInstant(),
                ZoneId.systemDefault());

        return ChronoUnit.SECONDS.between(currentDateTime, midnight);
    }
}
