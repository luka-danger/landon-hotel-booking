package edu.wgu.d387_sample_code.il8n;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TimeZoneConversion {

   static String displayPresentation = "";

   public static void main(String[] args) {
      String displayPresentation = displayPresentation();
      System.out.println(displayPresentation);
   };

   public static String displayPresentation() {
      String edtTimeString = "10-25-2024 09:30 AM";
      String presentation = "";

      try {
         // EDT
         DateFormat edtFormatter = new SimpleDateFormat("10-25-2024 HH:mm a");
         edtFormatter.setTimeZone(TimeZone.getTimeZone("America/New_York"));
         Date edtDate = edtFormatter.parse(edtTimeString);

         // Convert EDT time to MDT
         DateFormat mdtFormatter = new SimpleDateFormat("HH:mm a");
         mdtFormatter.setTimeZone(TimeZone.getTimeZone("America/Denver"));
         String mdtTimeString = mdtFormatter.format(edtDate);

         // Convert EDT time to UTC
         DateFormat utcFormatter = new SimpleDateFormat("HH:mm a");
         utcFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
         String utcTimeString = utcFormatter.format(edtDate);

         presentation = ("Join us for a live and only presentation! Live Presentation Date: " + edtTimeString + " EDT. " +
                 "Online Presentation Time: " + mdtTimeString + " MDT" + " | " + utcTimeString + " UTC");


      } catch (Exception e) {
         e.printStackTrace();
      }
      return presentation;

   }


}
