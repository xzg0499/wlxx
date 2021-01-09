package com.xzg.wlxx.demo;

import cn.hutool.core.util.XmlUtil;
import cn.hutool.json.JSONObject;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2020/12/23
 */
public class Test5 {
    public static void main(String[] args) {
        String xmlStr = "<env:Envelope xmlns:env=\"http://www.w3.org/2003/05/soap-envelope\"><env:Header/><env:Body><n0:JournalEntryBulkCreateConfirmation xmlns:n0=\"http://sap.com/xi/SAPSCORE/SFIN\" xmlns:prx=\"urn:sap.com:proxy:TWE:/1SAI/TAS3D871C7855B59197A671:782\"><MessageHeader><UUID>fa163ebf-4462-1eeb-91a6-61441e7b2a1b</UUID><CreationDateTime>2020-12-23T15:25:08.106484Z</CreationDateTime><SenderBusinessSystemID>TWE</SenderBusinessSystemID></MessageHeader><ConfirmationInterfaceOrignName/><JournalEntryCreateConfirmation><MessageHeader><UUID>fa163ebf-4462-1eeb-91a6-61441e7b4a1b</UUID><CreationDateTime>2020-12-23T15:25:08.106547Z</CreationDateTime></MessageHeader><JournalEntryCreateConfirmation><AccountingDocument> </AccountingDocument><CompanyCode> </CompanyCode><FiscalYear>0000</FiscalYear></JournalEntryCreateConfirmation><Log><MaximumLogItemSeverityCode>3</MaximumLogItemSeverityCode><Item><TypeID>609(RW)</TypeID><SeverityCode>3</SeverityCode><Note>Error in document: BKPFF $ 0M32TI1</Note><WebURI>http://vhshptweci.shp.sha.s4h.sap.corp:50000/sap/xi/docu_apperror?ID=NA&amp;OBJECT=RW609&amp;LANGUAGE=E&amp;MSGV1=BKPFF&amp;MSGV2=%24&amp;MSGV3=0M32TI1</WebURI></Item><Item><TypeID>102(F5)</TypeID><SeverityCode>3</SeverityCode><Note>Customer 2 is not defined in company code LJJA</Note><WebURI>http://vhshptweci.shp.sha.s4h.sap.corp:50000/sap/xi/docu_apperror?ID=NA&amp;OBJECT=F5102&amp;LANGUAGE=E&amp;MSGV1=2&amp;MSGV2=LJJA</WebURI></Item><Item><TypeID>102(F5)</TypeID><SeverityCode>3</SeverityCode><Note>Customer 2 is not defined in company code LJJA</Note><WebURI>http://vhshptweci.shp.sha.s4h.sap.corp:50000/sap/xi/docu_apperror?ID=NA&amp;OBJECT=F5102&amp;LANGUAGE=E&amp;MSGV1=2&amp;MSGV2=LJJA</WebURI></Item><Item><TypeID>104(F5)</TypeID><SeverityCode>3</SeverityCode><Note>Vendor 141 is not defined in company code LJJA</Note><WebURI>http://vhshptweci.shp.sha.s4h.sap.corp:50000/sap/xi/docu_apperror?ID=NA&amp;OBJECT=F5104&amp;LANGUAGE=E&amp;MSGV1=141&amp;MSGV2=LJJA</WebURI></Item><Item><TypeID>104(F5)</TypeID><SeverityCode>3</SeverityCode><Note>Vendor 442 is not defined in company code LJJA</Note><WebURI>http://vhshptweci.shp.sha.s4h.sap.corp:50000/sap/xi/docu_apperror?ID=NA&amp;OBJECT=F5104&amp;LANGUAGE=E&amp;MSGV1=442&amp;MSGV2=LJJA</WebURI></Item><Item><TypeID>507(F5)</TypeID><SeverityCode>3</SeverityCode><Note>G/L account 1002010100 is not defined in chart of accounts YCOA</Note><WebURI>http://vhshptweci.shp.sha.s4h.sap.corp:50000/sap/xi/docu_apperror?ID=NA&amp;OBJECT=F5507&amp;LANGUAGE=E&amp;MSGV1=1002010100&amp;MSGV2=YCOA</WebURI></Item><Item><TypeID>004(FH)</TypeID><SeverityCode>3</SeverityCode><Note>Account 1002010100 does not exist in chart of accounts YCOA</Note></Item></Log></JournalEntryCreateConfirmation><Log/></n0:JournalEntryBulkCreateConfirmation></env:Body></env:Envelope>";
        Map<String,Object> map = XmlUtil.xmlToMap(xmlStr);
        JSONObject json = new JSONObject();
        json.putAll(map);
        System.out.println(json.toString());
        System.out.println(map);
        System.out.println(json.getJSONObject("env:Body")
                .getJSONObject("n0:JournalEntryBulkCreateConfirmation")
                .getJSONObject("JournalEntryCreateConfirmation").getJSONObject("Log")
                .getJSONArray("Item").getJSONObject(0).get("Note"));
    }
}
