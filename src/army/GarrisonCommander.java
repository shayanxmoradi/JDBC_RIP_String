package army;

import java.util.ArrayList;
import java.util.List;

public class GarrisonCommander {

   static private List<String> reportList = new ArrayList<String>();

    public static List<String> getReportList() {
        return reportList;
    }
    public static void showReportList() {
        System.out.println(reportList);
    }

    public static void setReportList(List<String> reportList) {
        GarrisonCommander.reportList = reportList;
    }
}
