package com.zq.learn.stonecommon.utils;

import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {
	public static final String PATTERN_YYYY_MM_DD = "yyyy-MM-dd";
	 /** 完整时间 yyyy-MM-dd HH:mm:ss */
    public static final String simple = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";
    public static final String yyyyMd = "yyyy-M-d";
    public static final String yyyyMMdd = "yyyy-MM-dd";
    public static final String HHmm = "HH:mm";
    public static final String MMdd = "MM月dd";
    public static final String yyyyMM = "yyyy年MM";
    public static final String yyyy = "yyyy年";
	public static Date startDate;
	static {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			startDate = sdf.parse("2010-01-01");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取日期(精确到毫秒)格式化，格式：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public  static String getDateFormatter(Date date){
		DateFormat df=new SimpleDateFormat(simple);
		return df.format(date);
	}

	/**
	 * 获取当前从2010-01-01的秒数
	 * 
	 * @return
	 */
	public static Integer getSecondsFrom2010() {
		return getSecondsBetween(new Date(), startDate);
	}

	public static Integer getSecondsFrom2010(Date date) {
		return getSecondsBetween(date, startDate);
	}

	/**
	 * 
	 * @param seconds
	 *            从2010-01-01的秒数
	 * @return
	 */
	public static Date getDateFrom2010sec(Number seconds) {
		if(seconds == null){
			return null;
		}
		long times = startDate.getTime() + seconds.longValue() * 1000;
		Date date = new Date();
		date.setTime(times);

		return date;
	}

	private static Integer getSecondsBetween(Date date1, Date date2) {
		return (int) (Math.abs(date1.getTime() - date2.getTime()) / 1000);
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formatDate(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * 判断两个日期是否是同一天
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameDay(Date date1, Date date2) {
		if(date1 == null || date2 == null){
			return false;
		}
		DateTime dateTime1 = new DateTime(date1);
		DateTime dateTime2 = new DateTime(date2);

		return dateTime1.getYear() == dateTime2.getYear()
				&& dateTime1.getMonthOfYear() == dateTime2.getMonthOfYear()
				&& dateTime1.getDayOfMonth() == dateTime2.getDayOfMonth();
	}
	
	public static boolean isSameDay(DateTime dateTime1, DateTime dateTime2) {
		if(dateTime1 == null || dateTime2 == null){
			return false;
		}
		return dateTime1.getYear() == dateTime2.getYear()
				&& dateTime1.getMonthOfYear() == dateTime2.getMonthOfYear()
				&& dateTime1.getDayOfMonth() == dateTime2.getDayOfMonth();
	}

	public static boolean isSameWeek(Date compareData, Date curDate) {
		if(compareData == null || curDate == null){
			return false;
		}
		if(compareData.getTime() == curDate.getTime()){
			return true;
		}
		
		DateTime dateTime2 = new DateTime(curDate);
		
		//获取compareData所在week的第一天 和最后一天
		DateTime dateTime = new DateTime(compareData);
		int dayOfWeek = dateTime.getDayOfWeek();
		if(dayOfWeek == 7){
			//调到下礼拜 随便那一天
			dateTime = dateTime.plusDays(3);
		}
		DateTime startTime = dateTime.withDayOfWeek(1).withHourOfDay(0).withMinuteOfHour(0)
			.withSecondOfMinute(0).withMillisOfSecond(0);
		
		//joda默认是从礼拜一开始的，而我们的系统需要从礼拜天开始
		startTime = startTime.plusDays(-1);
		DateTime endTime = startTime.plusWeeks(1);
		return dateTime2.isAfter(startTime.getMillis()) && dateTime2.isBefore(endTime.getMillis());
	}

	public static boolean isSameMonth(Date compareData, Date curDate) {
		if(compareData == null || curDate == null){
			return false;
		}
		DateTime dateTime1 = new DateTime(compareData);
		DateTime dateTime2 = new DateTime(curDate);
		return dateTime1.getYear() == dateTime2.getYear() &&
				dateTime1.getMonthOfYear() == dateTime2.getMonthOfYear();
	}

	public static boolean isSameYear(Date compareData, Date curDate) {
		if(compareData == null || curDate == null){
			return false;
		}
		DateTime dateTime1 = new DateTime(compareData);
		DateTime dateTime2 = new DateTime(curDate);
		return dateTime1.getYear() == dateTime2.getYear();
	}
	
	public static boolean isSameYear(DateTime dateTime1, DateTime dateTime2) {
		if(dateTime1 == null || dateTime2 == null){
			return false;
		}
		return dateTime1.getYear() == dateTime2.getYear();
	}

	
	/**
	 * 获取当前日期所在周的第一天
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfWeek(Date date){
		DateTime dateTime = new DateTime(date);
		int dayOfWeek = dateTime.dayOfWeek().get();
		
		return new DateTime(dateTime.getYear(),dateTime.getMonthOfYear(),dateTime.getDayOfMonth(),0,0,0)
				.minusDays(dayOfWeek).toDate();
	}
	
	

	
	/**
	 * 获取从秒数
	 * 
	 * @param date
	 * @param grain 
	 * @return
	 */
	private static long getStartTime(Date date) {
		DateTime dateTime = new DateTime(date);
		DateTime dateTime1 = new DateTime(dateTime.getYear(),
				dateTime.getMonthOfYear(), dateTime.getDayOfMonth(), 0, 0);
		return DateUtils.getSecondsFrom2010(dateTime1.toDate());
	}


	public static boolean isSameMonth(DateTime date, DateTime dateTime) {
		return date.getYear() == dateTime.getYear() && 
				date.getMonthOfYear() == dateTime.getMonthOfYear();
	}

	/**
	 * 获取指定时间所在月份的最大天数
	 * @param date
	 * @return
	 */
	public static int daysOfMonth(DateTime date) {
		return date.dayOfMonth().getMaximumValue();
	}

	/**
	 * 获取所在地的时区
	 * @return
	 */
	public static long getTimeZoneOffset() {
		Calendar cal = Calendar.getInstance();
		TimeZone timeZone = cal.getTimeZone();
		return timeZone.getRawOffset();
	}

	public static Date parseData(String date, String pattern) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(date);
	}

	public static boolean isTimeBetween(DateTime curDay, Date startTime, Date endTime) {
		if(curDay.isEqual(startTime.getTime()) ||
				(curDay.isAfter(startTime.getTime()) && curDay.isBefore(endTime.getTime()) )){
			return true;
		}
		return false;
	}

	public static DateTime getFirstDayOfMonth(DateTime day) {
		return day.withDayOfMonth(1).withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0);
	}

	public static DateTime getEndDayOfMonth(DateTime day) {
		DateTime firstDay = getFirstDayOfMonth(day);
		return firstDay.plusMonths(1).plusDays(-1);
	}
	//今日0点0分0秒时间
	public static DateTime getDailyFirst(DateTime curTime) {
		curTime = curTime.withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0);
		return curTime;
	}
	//明日0点0分0秒时间
	public static DateTime getTomorrowFirst(DateTime curTime) {
		curTime = curTime.plusDays(1);
		curTime = curTime.withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0);
		return curTime;
	}
	//当年的第一天
	public static DateTime getCurYearFirstDay() {
		Calendar currCal=Calendar.getInstance();  
	    int currentYear = currCal.get(Calendar.YEAR);
	    Date date = getYearFirst(currentYear);
	    return new DateTime(date);
	}
	//明年第一天
	public static DateTime getCurYearEndDay() {
		Calendar currCal=Calendar.getInstance();  
	    int currentYear = currCal.get(Calendar.YEAR);
	    Date date = getYearFirst(currentYear);
	    return new DateTime(date).plusYears(1);
	}
	 /**
     * 获取某年第一天日期
     * @param year 年份
     * @return Date
     */
    public static Date getYearFirst(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

	public static void main(String[] args) throws ParseException {
		Date dateFrom2010sec = DateUtils.getDateFrom2010sec(229683681);
		System.out.println(dateFrom2010sec);
	}

}
