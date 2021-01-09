package com.xzg.wlxx.demo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 模拟soapUI调用WebService,解析返回报文
 * Created by PengHongfu 2018-04-26 15:36
 */
public class Test3 {

    //测试环境地址
    public static String INVOICE_WS_URL = "https://my300522-api.saps4hanacloud.cn/sap/bc/srt/scs_ext/sap/journalentrycreaterequestconfi";

    public static void main(String[] args) throws Exception {

        String sid = "SID值";
        String content = "报文内容,jOSN格式";
        String tranSeq = "UUID";
        String tranReqDate = "2018-04-24";
        StringBuffer stringBuffer = testWebService(sid, content, tranSeq, tranReqDate);

        // 打印HTTP响应数据
        System.out.println(stringBuffer);


    }

    // 调用WS
    private static StringBuffer testWebService(String sid, String content, String tranSeq, String tranReqDate) throws Exception {
        //拼接请求报文
        String sendMsg = appendXmlContext(sid, content, tranSeq, tranReqDate);
        // 开启HTTP连接ַ
        InputStreamReader isr = null;
        BufferedReader inReader = null;
        StringBuffer result = null;
        OutputStream outObject = null;
        try {
            URL url = new URL(INVOICE_WS_URL);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

            // 设置HTTP请求相关信息
            httpConn.addRequestProperty("Content-Length",
                    String.valueOf(sendMsg.getBytes().length));
            httpConn.addRequestProperty("Authorization","Basic VEVTVFVTRVJJTjpXcVhka0pkR2t0RHV4M1JDd1NCS3Fub3Z1WkUrUFlOd1VnS0N4RVZu");
            httpConn.addRequestProperty("Content-Type","application/soap+xml;charset=UTF-8;action=\"http://sap.com/xi/SAPSCORE/SFIN/JournalEntryCreateRequestConfirmation_In/JournalEntryCreateRequestConfirmation_InRequest\"");
            httpConn.setRequestMethod("POST");
            httpConn.setUseCaches(false);
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);

            // 进行HTTP请求
            outObject = httpConn.getOutputStream();
            outObject.write(sendMsg.getBytes());

            if (200 != (httpConn.getResponseCode())) {
                throw new Exception("HTTP Request is not success, Response code is " + httpConn.getResponseCode());
            }
            // 获取HTTP响应数据
            isr = new InputStreamReader(
                    httpConn.getInputStream(), "utf-8");
            inReader = new BufferedReader(isr);
            result = new StringBuffer();
            String inputLine;
            while ((inputLine = inReader.readLine()) != null) {
                result.append(inputLine);
            }
            return result;

        } catch (IOException e) {
            throw e;
        } finally {
            // 关闭输入流
            if (inReader != null) {
                inReader.close();
            }
            if (isr != null) {
                isr.close();
            }
            // 关闭输出流
            if (outObject != null) {
                outObject.close();
            }
        }

    }

    //拼接请求报文
    private static String appendXmlContext(String sid, String content, String tranSeq, String tranReqDate) {
        // 构建请求报文

//        StringBuffer stringBuffer = new StringBuffer("<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:sfin=\"http://sap.com/xi/SAPSCORE/SFIN\">" +
//                "<soap:Header/>" +
//                "<soap:Body>" +
//                "<sfin:JournalEntryBulkCreateRequest>" +
//                "<MessageHeader>" +
//                "<!--必填，当前时间-->" +
//                "<CreationDateTime>2020-11-19T07:08:24Z</CreationDateTime>" +
//                "</MessageHeader>" +
//                "<JournalEntryCreateRequest>" +
//                "<MessageHeader>" +
//                "<!--必填，当前时间-->" +
//                "<CreationDateTime>2020-11-19T07:08:24Z</CreationDateTime>" +
//                "</MessageHeader>" +
//                "<JournalEntry>" +
//                "<!--必填，固定值，BKPFF-->" +
//                "<OriginalReferenceDocumentType>BKPFF</OriginalReferenceDocumentType>" +
//                "<!--必填，固定值，RFBU-->" +
//                "<BusinessTransactionType>RFBU</BusinessTransactionType>" +
//                "<!--必填，固定值，SA-->" +
//                "<AccountingDocumentType>SA</AccountingDocumentType>" +
//                "<!--选填，参考，char(16)-->" +
//                "<DocumentReferenceID>12345</DocumentReferenceID>" +
//                "<!--选填，凭证抬头文本，CHAR (25)-->" +
//                "<DocumentHeaderText>凭证抬头文本</DocumentHeaderText>" +
//                "<!--必填，创建人，SAP中用户的CB User，CHAR (12)-->" +
//                "<CreatedByUser>CB9980000001</CreatedByUser>" +
//                "<!--必填，公司代码-->" +
//                "<CompanyCode>LJJA</CompanyCode>" +
//                "<!--必填，凭证日期-->" +
//                "<DocumentDate>2020-11-19</DocumentDate>" +
//                "<!--必填，过账日期-->" +
//                "<PostingDate>2020-11-19</PostingDate>" +
//                "<Item>" +
//                "<!--必填，总账科目-->" +
//                "<GLAccount>1002010100</GLAccount>" +
//                "<!--必填，交易货币金额-->" +
//                "<AmountInTransactionCurrency currencyCode=\"cny\">-6000</AmountInTransactionCurrency>" +
//                "<!--必填，借贷方，贷-H,借-S-->" +
//                "<DebitCreditCode>H</DebitCreditCode>" +
//                "<!--选填，凭证行项目文本，char(50)-->" +
//                "<DocumentItemText>借款接口测试</DocumentItemText>" +
//                "<!--Optional: 原因代码, char(3)-->" +
//                "<ReasonCode>?</ReasonCode>" +
//                "<!--Optional:科目分配-->" +
//                "<AccountAssignment>" +
//                "<!--Optional:成本中心编号, char(10)-->" +
//                "<CostCenter>?</CostCenter>" +
//                "</AccountAssignment>" +
//                "</Item>" +
//                "<DebtorItem>" +
//                "<!--必填，参考凭证行项目，NUMC (6), 从1开始，依次增加-->" +
//                "<ReferenceDocumentItem>1</ReferenceDocumentItem>" +
//                "<!--必填，客户编号，char(10)-->" +
//                "<Debtor>2</Debtor>" +
//                "<!--必填，交易货币金额-->" +
//                "<AmountInTransactionCurrency currencyCode=\"cny\">3000.00</AmountInTransactionCurrency>" +
//                "<!--必填，借贷方，贷-H,借-S-->" +
//                "<DebitCreditCode>S</DebitCreditCode>" +
//                "<!--选填，凭证行项目文本，char(50)-->" +
//                "<DocumentItemText>借款接口测试</DocumentItemText>" +
//                "<DownPaymentTerms>" +
//                "<!--选填，特殊总账标识，char(1)-->" +
//                "<SpecialGLCode>E</SpecialGLCode>" +
//                "</DownPaymentTerms>" +
//                "</DebtorItem>" +
//                "<CreditorItem>" +
//                "<!--必填，参考凭证行项目，NUMC (6),-->" +
//                "<ReferenceDocumentItem>2</ReferenceDocumentItem>" +
//                "<!--必填，供应商编号，char(10)-->" +
//                "<Creditor>141</Creditor>" +
//                "<AmountInTransactionCurrency currencyCode=\"cny\">1000.00</AmountInTransactionCurrency>" +
//                "<DebitCreditCode>S</DebitCreditCode>" +
//                "<DocumentItemText>借款接口测试</DocumentItemText>" +
//                "<DownPaymentTerms>" +
//                "<SpecialGLCode>A</SpecialGLCode>" +
//                "</DownPaymentTerms>" +
//                "</CreditorItem>" +
//                "<CreditorItem>" +
//                "<ReferenceDocumentItem>3</ReferenceDocumentItem>" +
//                "<Creditor>442</Creditor>" +
//                "<AmountInTransactionCurrency currencyCode=\"cny\">2000.00</AmountInTransactionCurrency>" +
//                "<DebitCreditCode>S</DebitCreditCode>" +
//                "<DocumentItemText>借款接口测试</DocumentItemText>" +
//                "<DownPaymentTerms>" +
//                "<SpecialGLCode/>" +
//                "</DownPaymentTerms>" +
//                "</CreditorItem>" +
//                "</JournalEntry>" +
//                "</JournalEntryCreateRequest>" +
//                "</sfin:JournalEntryBulkCreateRequest>" +
//                "</soap:Body>" +
//                "</soap:Envelope>");
        StringBuffer stringBuffer = new StringBuffer("<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\"\n" +
                "    xmlns:sfin=\"http://sap.com/xi/SAPSCORE/SFIN\">\n" +
                "    <soap:Header/>\n" +
                "    <soap:Body>\n" +
                "        <sfin:JournalEntryBulkCreateRequest>\n" +
                "            <MessageHeader>                <!--必填，当前时间-->\n" +
                "                <CreationDateTime>2020-11-19T07:08:24Z</CreationDateTime>\n" +
                "            </MessageHeader>\n" +
                "            <JournalEntryCreateRequest>\n" +
                "                <MessageHeader>                    <!--必填，当前时间-->\n" +
                "                    <CreationDateTime>2020-11-19T07:08:24Z</CreationDateTime>\n" +
                "                </MessageHeader>\n" +
                "                <JournalEntry>                    <!--必填，固定值，BKPFF-->\n" +
                "                    <OriginalReferenceDocumentType>BKPFF</OriginalReferenceDocumentType>                    <!--必填，固定值，RFBU-->\n" +
                "                    <BusinessTransactionType>RFBU</BusinessTransactionType>                    <!--必填，固定值，SA-->\n" +
                "                    <AccountingDocumentType>SA</AccountingDocumentType>                    <!--选填，参考，char(16)-->\n" +
                "                    <DocumentReferenceID>12345</DocumentReferenceID>                    <!--选填，凭证抬头文本，CHAR (25)-->\n" +
                "                    <DocumentHeaderText>凭证抬头文本</DocumentHeaderText>                    <!--必填，创建人，SAP中用户的CB User，CHAR (12)-->\n" +
                "                    <CreatedByUser>CB9980000001</CreatedByUser>                    <!--必填，公司代码-->\n" +
                "                    <CompanyCode>LJJA</CompanyCode>                    <!--必填，凭证日期-->\n" +
                "                    <DocumentDate>2020-11-19</DocumentDate>                    <!--必填，过账日期-->\n" +
                "                    <PostingDate>2020-11-19</PostingDate>\n" +
                "                    <Item>                        <!--必填，总账科目-->\n" +
                "                        <GLAccount>1002010100</GLAccount>                        <!--必填，交易货币金额-->\n" +
                "                        <AmountInTransactionCurrency currencyCode=\"cny\">-6000</AmountInTransactionCurrency>                        <!--必填，借贷方，贷-H,借-S-->\n" +
                "                        <DebitCreditCode>H</DebitCreditCode>                        <!--选填，凭证行项目文本，char(50)-->\n" +
                "                        <DocumentItemText>借款接口测试</DocumentItemText>                        <!--Optional: 原因代码, char(3)-->\n" +
                "                        <ReasonCode>?</ReasonCode>                        <!--Optional:科目分配-->\n" +
                "                        <AccountAssignment>                            <!--Optional:成本中心编号, char(10)-->\n" +
                "                            <CostCenter>?</CostCenter>\n" +
                "                        </AccountAssignment>\n" +
                "                    </Item>\n" +
                "                    <DebtorItem>                        <!--必填，参考凭证行项目，NUMC (6), 从1开始，依次增加-->\n" +
                "                        <ReferenceDocumentItem>1</ReferenceDocumentItem>                        <!--必填，客户编号，char(10)-->\n" +
                "                        <Debtor>2</Debtor>                        <!--必填，交易货币金额-->\n" +
                "                        <AmountInTransactionCurrency currencyCode=\"cny\">3000.00</AmountInTransactionCurrency>                        <!--必填，借贷方，贷-H,借-S-->\n" +
                "                        <DebitCreditCode>S</DebitCreditCode>                        <!--选填，凭证行项目文本，char(50)-->\n" +
                "                        <DocumentItemText>借款接口测试</DocumentItemText>\n" +
                "                        <DownPaymentTerms>                            <!--选填，特殊总账标识，char(1)-->\n" +
                "                            <SpecialGLCode>E</SpecialGLCode>\n" +
                "                        </DownPaymentTerms>\n" +
                "                    </DebtorItem>\n" +
                "                    <CreditorItem>                        <!--必填，参考凭证行项目，NUMC (6),-->\n" +
                "                        <ReferenceDocumentItem>2</ReferenceDocumentItem>                        <!--必填，供应商编号，char(10)-->\n" +
                "                        <Creditor>141</Creditor>\n" +
                "                        <AmountInTransactionCurrency currencyCode=\"cny\">1000.00</AmountInTransactionCurrency>\n" +
                "                        <DebitCreditCode>S</DebitCreditCode>\n" +
                "                        <DocumentItemText>借款接口测试</DocumentItemText>\n" +
                "                        <DownPaymentTerms>\n" +
                "                            <SpecialGLCode>A</SpecialGLCode>\n" +
                "                        </DownPaymentTerms>\n" +
                "                    </CreditorItem>\n" +
                "                    <CreditorItem>\n" +
                "                        <ReferenceDocumentItem>3</ReferenceDocumentItem>\n" +
                "                        <Creditor>442</Creditor>\n" +
                "                        <AmountInTransactionCurrency currencyCode=\"cny\">2000.00</AmountInTransactionCurrency>\n" +
                "                        <DebitCreditCode>S</DebitCreditCode>\n" +
                "                        <DocumentItemText>借款接口测试</DocumentItemText>\n" +
                "                        <DownPaymentTerms>\n" +
                "                            <SpecialGLCode/>\n" +
                "                        </DownPaymentTerms>\n" +
                "                    </CreditorItem>\n" +
                "                </JournalEntry>\n" +
                "            </JournalEntryCreateRequest>\n" +
                "        </sfin:JournalEntryBulkCreateRequest>\n" +
                "    </soap:Body>\n" +
                "</soap:Envelope>\n");
        return stringBuffer.toString();
    }


}
