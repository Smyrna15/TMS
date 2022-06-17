package repos;

import enums.LINES;
import models.InquiryBody;

import java.util.HashMap;
import java.util.Map;

public class InquiryRepo {
   static Map<String, InquiryBody> inquiryTestData = new HashMap<>()
    {{
        put("orange_line",new InquiryBody("01200341116",  "36", "6")); //"en"
        put("vf_line",new InquiryBody("01000341116",  "36", "6")); //"en"
        put("etsalat_line",new InquiryBody("01100341116",  "36", "6")); //"en"
        put("landline",new InquiryBody("0862352989",  "36", "6")); //"en"

    }
    };
    public static InquiryBody get(LINES line)
    {
        return  inquiryTestData.get(line.getValue());
    }
}
