package com.kronos.showcase.zerocode.uat;

import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicLong;

public class BatchHelper {

    private static final String BATCH_PROCESSING_ROOT_URL = "http://artashes-aroyan-local.int.dev.mykronos.com/wfc/restcall/v1/platform/batch_processing";
    private static final String GET_ROOT_URL = "?all_details=false";
    private static final String CREATE_ROOT_URL = "/multi_create";
    private static final String DELETE_ROOT_URL = "/multi_delete";

    private static final String BATCH_TASK_ROOT_URL = BATCH_PROCESSING_ROOT_URL.concat("/batch_tasks");
    public static final String BATCH_TASK_GET_URL = BATCH_TASK_ROOT_URL.concat(GET_ROOT_URL);
    public static final String BATCH_TASK_CREATE_URL = BATCH_TASK_ROOT_URL.concat(CREATE_ROOT_URL);
    public static final String BATCH_TASK_DELETE_URL = BATCH_TASK_ROOT_URL.concat(DELETE_ROOT_URL);

    private static final String BATCH_EVENT_ROOT_URL = BATCH_PROCESSING_ROOT_URL.concat("/batch_events");
    public static final String BATCH_EVENT_GET_URL = BATCH_EVENT_ROOT_URL.concat(GET_ROOT_URL);
    public static final String BATCH_EVENT_CREATE_URL = BATCH_EVENT_ROOT_URL.concat(CREATE_ROOT_URL);
    public static final String BATCH_EVENT_DELETE_URL = BATCH_EVENT_ROOT_URL.concat(DELETE_ROOT_URL);

    private static final String BATCH_GROUP_ROOT_URL = BATCH_PROCESSING_ROOT_URL.concat("/batch_groups");
    public static final String BATCH_GROUP_GET_URL = BATCH_GROUP_ROOT_URL.concat(GET_ROOT_URL);
    public static final String BATCH_GROUP_CREATE_URL = BATCH_GROUP_ROOT_URL.concat(CREATE_ROOT_URL);
    public static final String BATCH_GROUP_DELETE_URL = BATCH_GROUP_ROOT_URL.concat(DELETE_ROOT_URL);


    public static String getCookies() {
        return "_csrf=DUNJMYYcUaCsOlhVcgfqeamC; authnamlbcookie=01; VANITY_URL=\"http://artashes-aroyan-local.int.dev.mykronos.com/?tenantId=healthcare\"; AUTHN_TOKEN=\"eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IjlEOGxWeUExY0lvN2REQVZXMXBVcXl4VEwyND0ifQ.eyJpc3MiOiJodHRwOi8va2VuZzAzLWRldjAxLWF0aDEwLW9hbS5pbnQuZGV2Lm15a3Jvbm9zLmNvbTo4MCIsImlhdCI6MTYzNjEwODIxMCwiZXhwIjoxNjM2MTM3MDEwLCJzdWIiOiJDaGFybGVzUHJpbmNldG9uIiwibm9uY2UiOiI8RG4tMFM2X1d6QTJNaiIsInJlYWxtIjoiL2hlYWx0aGNhcmUiLCJpcHIiOmZhbHNlLCJvaWRjU2Vzc2lvbiI6ZmFsc2V9.NHFuuhaYrw-AASzWggWMDyTqRz0Us68i7U8PpCiwNDPQnUwbgf9_TasEeGuYf3wrV4MiLKM8pNg5lTrZAIB-OBePRPRLfIYQppLWvehF2Hb0YMM0ngOcR2yerb-_geKXln5ePMgDoAc-5RFLmkM6xmsotLR0kxEBMyyo6FTgLol_Lho7t8BTzN-7HT-qlCxOo3NbkeIt6aQrCu_2O4ky6lkL6kZxOrnfp3CPkP5PCc9NoUpFor1pllQzhifvcmwGghtxMrzcV8DgqmkPSLK8ZZukKkqYUOco24zIDqKTDAhZJSfqRbZW7Fwto3znPq44JAmihY4OyNFMieoCWWxlWQ|ejNmdFMzZ0ZoVFNUQkg1YlRNRmJIMDEzTEFDVGlZQjd0OUplY3NYakZOTmlmdDNrczRDUFMybWxUOC9pK3pkNTdHV09RU1BrWDZqWGNnaC9IZnpkNjhrTStSY1VZNk41UjA0SDZicUxvaVN6M0p1c2tHcVZRNmhla3dTN3h5aTEyZVZtbGg2MkF0UkRSbVRENTJocE14WFRxNWVCOVVZVGRNelBpWHJKcnRRQ0U4V04wM25qUFJ4UVNialQxZm8vdGh5NklSMW1Rb1F1TytON25xUFJRbUxoamNBbHJTTjBBZzZXSTM5cWF5RnBrUmsrQitNbXl2Sjg3WHgzSjV3S3dxRkVOZWRXZlJzODdCQXp6NHJqTTNyT0tJd3RjdlBDK25kM083RHREeTM5TFRlMmxTZFVtMGNFZ2VDK3luVGNFUCtyMnB1ZmFmWGlLYkpsY3dyOUVCazJVQmtadnpjTzBjbzV6YzRna08zeEtYeWtpNU81RDBuYlhGQVMrNmdWMkttT2ZRM3lOKzBJcWRXWnZ1SGJXT1RYU0x6QXdhSDRmOHcrSDA5L2Izb3pQZkxSQTlYdjVtK1huYWpoNkE5MGk1Rk0vaGl2bHdSejFoNGJBSW9scWw3YjQ5bFFtVGo0ckVSRmpmemVGWFcydzdENWR6MWNicHBuVDRVSko0azhTYksvWEFsUkZBMWxJaVhxZzhBTkVEWTlVeDViKy96SURLcEp0d3hDMkFISjZkR0cxZHZKKzR3TmpqZTBITDBpUS9iSEd0dmNoaEkrWWxwSURaZGpKcGtXbXBsd0dvN1RXa09SdXM1cjMrV3A4cVFWdStQUEFieFVDcWtndUtjTjZSUmlMTkRTeWFpVWsreG10N2x2SjdDWG9LdTJLRmxRZ2xKVDhELy9EN1VVS2JGbitwaVYxUGNJQ3B0SW9WcGI=\"; IDP_URI=\"aHR0cHM6Ly9vYW0xMC5kZXYubXlrcm9ub3MuY29tL2F1dGhuL2hlYWx0aGNhcmU=\"; TENANT_AUTHORIZATION=\"yTeOCkNlPB/TI4r778EwSiTYFkcDcxwK2uYqcrBEK2Y=\"; authn_ssid=2kE707pctCyz2YQ1Xlvic1stEDk.*AAJTSQACMDIAAlNLABxhZVQzYTZCYm5yRlhKbVh6TFpJdEE0V2p0N2M9AAR0eXBlAANDVFMAAlMxAAIwNQ..*; _ga=GA1.2.1868095499.1636108215; _gid=GA1.2.2047550513.1636108215; falconAuthCookie=true; ssologin=true; JSESSIONID=F56EE5A3D45DF76FEA71A22C9661BCA0; AUTHZ_TOKEN=MFJzZVl3S0hyRmNHMU9XVHRPd2NnTkE3cGNSNW10Qy9sZEQ3eDlKV3NVMGpQbHRZZkVyMG53WDVIWVkvZ3o5NEVNVTI3K25BdExHOHFKa0swL2liNDNpV1FQdG52R2xvZmlJWTBXVHJ0ait6a1BRbC9PSDk1OVFVOEpxb3pBTjM0ZnN2blhLRDUyb0hhTTJuMklOMFROa3pPTE5xYVU5cHlaeEk4MlZKbXU5K1BpWHJHSWtZL1p0UkpCdklKM2FPOFNSMWpncUppUUZ6cVRuRURVOHN6NzlxN1hGa1lvWEozNTY1VjB5SGJrMk01NzNVU2l2aWo0YVo3Rlo5eThEMVpubXNiOVQrQUpmUDFTbTRMMThORVpONW80V1RGa1F1UWU1M2pLSklhU3J3TDk4NDhBcEdqNlcrcWRlaWFJWTE=; authn_external_ssid=2kE707pctCyz2YQ1Xlvic1stEDk.*AAJTSQACMDIAAlNLABxhZVQzYTZCYm5yRlhKbVh6TFpJdEE0V2p0N2M9AAR0eXBlAANDVFMAAlMxAAIwNQ..*; kronosAuthToken=c8a486a6fd3142a3f1cfa8a2966c410c8064841c; kronosCookie=JSESSIONID=F56EE5A3D45DF76FEA71A22C9661BCA0;WFC_USER=oNyhfgBqg8Fu+tDAit7L01Rcg08WNmtxYefYqKuuBUKIbNSgd0Jkh/Ch8Q5muTASJW73CCeqGlTnJUmH3CMHSA--;WFC_TENANT_ID=ZfyD8D/mnWpLQj7zwfRcQv8MSl6y/nZ4IBzM0JEzznm6vIJJEqAtgViBPRhhPNa+;JSESSIONID=F56EE5A3D45DF76FEA71A22C9661BCA0;AUTHZ_TOKEN=\"MFJzZVl3S0hyRmNHMU9XVHRPd2NnTkE3cGNSNW10Qy9sZEQ3eDlKV3NVMGpQbHRZZkVyMG53WDVIWVkvZ3o5NEVNVTI3K25BdExHOHFKa0swL2liNDNpV1FQdG52R2xvZmlJWTBXVHJ0ait6a1BRbC9PSDk1OVFVOEpxb3pBTjM0ZnN2blhLRDUyb0hhTTJuMklOMFROa3pPTE5xYVU5cHlaeEk4MlZKbXU5K1BpWHJHSWtZL1p0UkpCdklKM2FPOFNSMWpncUppUUZ6cVRuRURVOHN6NzlxN1hGa1lvWEozNTY1VjB5SGJrMk01NzNVU2l2aWo0YVo3Rlo5eThEMVpubXNiOVQrQUpmUDFTbTRMMThORVpONW80V1RGa1F1UWU1M2pLSklhU3J3TDk4NDhBcEdqNlcrcWRlaWFJWTE=\";; securityToken=Y765-G69Z-NYTH-8SQX-7RLA-2PYZ-IM6Z-QEFX; widgetToken=0f77ca29-9832-4446-bf92-6066c8b68267; allTokens=j:{\"com.kronos.wfc.ngui.search\":{\"value\":\"0f77ca29-9832-4446-bf92-6066c8b68267\"},\"com.kronos.wfc.ngui.peopleeditor\":{\"value\":\"b19fe19a-db3c-4c56-af1d-a701ff1962a2\"},\"com.kronos.wfc.ngui.scheduleRest\":{\"value\":\"ca60cfc9-9532-4f22-9a93-75bec24509a4\"},\"com.kronos.wfc.ngui.generictimeeditor_mgr\":{\"value\":\"7210dc22-45a3-42b6-ac49-3202846e7655\"},\"com.kronos.wfc.ngui.generictimeeditor_emp\":{\"value\":\"a87531c6-a79b-4349-8281-f07d0d3210d4\"},\"com.kronos.wfc.ngui.calendar\":{\"value\":\"00e6181e-8485-456b-b0e2-d35c7adb50a5\"},\"timeStampTileToken\":{\"value\":\"0a0dcdfe-1b92-42fb-8fe0-41805f6af3a9\"}}; deviceType=desktop; WFC_USER=oNyhfgBqg8Fu+tDAit7L01Rcg08WNmtxYefYqKuuBUKIbNSgd0Jkh/Ch8Q5muTASJW73CCeqGlTnJUmH3CMHSA--; WFC_TENANT_ID=ZfyD8D/mnWpLQj7zwfRcQv8MSl6y/nZ4IBzM0JEzznm6vIJJEqAtgViBPRhhPNa+; XSRF-TOKEN=lAzVo4BF-aoCO1X0jZw8nPtMa21trxThiKbU";
    }

    public static RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    private static AtomicLong atomicLong = new AtomicLong(68);

    public static long getId() {
        long id = atomicLong.incrementAndGet();
        atomicLong = new AtomicLong(id);
        return id;
    }

}
