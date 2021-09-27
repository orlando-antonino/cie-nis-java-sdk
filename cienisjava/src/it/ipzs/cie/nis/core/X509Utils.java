package it.ipzs.cie.nis.core;

import javax.security.auth.x500.X500Principal;
import java.security.cert.X509Certificate;
import java.util.*;


public class X509Utils {

    private Map<String,String> certs = null;

    private  void loadCertsCSCA() {
        certs = new HashMap<>();
        certs.put("436CE3921D10922307EFD7A2F577ED7524467F1B","308205F4308203DCA0030201020208014E793EA55DCDA2300D06092A864886F70D01010505003081853122302006035504030C194974616C69616E20436F756E747279205369676E657220434131333031060355040B0C2A4E6174696F6E616C20456C656374726F6E69632043656E746572206F6620537461746520506F6C696365311D301B060355040A0C144D696E6973747279206F6620496E746572696F72310B3009060355040613024954301E170D3136303930363039343333315A170D3331313230323039343333315A3081853122302006035504030C194974616C69616E20436F756E747279205369676E657220434131333031060355040B0C2A4E6174696F6E616C20456C656374726F6E69632043656E746572206F6620537461746520506F6C696365311D301B060355040A0C144D696E6973747279206F6620496E746572696F72310B300906035504061302495430820222300D06092A864886F70D01010105000382020F003082020A0282020100B5F670D358ACB7E78DFD1D72ACA126A4969E1966BF71740B5BE6720163854078831610F31AE304C7C173E11C71F74019BFD1FA27AAC3F6BDDC89A752040DAD9B4A81CEC1B3E7B8DAAEE4F0D996DAB458D9843CECB851AF897B1844B9268A83DFC090C1E17FE12EC4A4DD7D5DEF464F6FEC2984CF3AC2575745EEAB5C1AC8B9DF0EFB969C50E81E3BB85A1C046E416B19DF4BE415C691821ADAD93BC0429417D26CE39AAF3A0F969508B6AE180FEC5F52B8F1B20403A49D86910017047136B361214359B2DAACA26D480147AABCB4E3B41215452F09033D6EF02755567EE63209DD3D5545BCA522F2FAC3710962595631D42C5C15A0CEE26C65CEC2313E8481479803DE8A1435C82D5C5075B0EE69D54458A9A43181790A1D1E0F10A6B74865AA3BBC699021C6EF1E5B152368058FCF4DEA9F10A54DDAF88306F3AF92C1D4BAA15F3AD0744E1D7F02C8D79EB2F4EB508E61F92FE586948ED3A038E48619D6420D47586CD46BB4747D036A7405A090FC73A44C417E4F3BB41FDC0CF88BA655F001FDC4104C67F922E7AD07059967A8E390EB28D3A5F34A6B15BDB991A29A62F38E2BC240F0AC5E3D2FC2AE125462F994A3FB5EA6ADFD820EF6C602DFDA389E8A871C78FCD71AB57827F733B0DD370CD085BE3A23BE22A4D391DBBE47751AF87E1A8FA694C7E14BC62159975C158195B6B41325A485CDB1A406600DF67338920F850203010001A3663064301D0603551D0E04160414436CE3921D10922307EFD7A2F577ED7524467F1B30120603551D130101FF040830060101FF020100301F0603551D23041830168014436CE3921D10922307EFD7A2F577ED7524467F1B300E0603551D0F0101FF040403020106300D06092A864886F70D0101050500038202010055AFCEACAA5A249173FB8522FB869D49F5451CD423C46990D6EBFF8AE261F0285BFFD1FB28D14D3B22BB950FBB13B0227A949D9B4C259FBE8D234A8D8FA4C82D599E1AB5E29C11804DDBB93F93F94A70C64AB85EB1999A50FD6C0CE65850C5692F2FB0A2AA13B74FEBC3AE18D9C277F1BF4FF1F5B618AF619EFF4B44D4C96ED2456183C5BEC4E718C11A33565FD99FC07A1446E92855D6CC7461F4A3623F4B7A433716343FF1282CE78292605EEAD1468C162236620334285909586F133D860FC46D902F118CF86019E7E51FA88EBC51A044E2FE75FBD2367CB7B6F15EF579340C893FF0606A568B4FD19EFA4F465C71B053A1E42A696A6401472FC889B5F8061B6B2E56044849F97C1FDCE91894251A8CF59F688E11C438CBD49F4465C92B01FE69D5FA90BAC461752653F949F6F734046D796AF79B9A8AB310F1130B966A09C4904A4CCEA63990114DDF750BEB1861B65A6E5A8472A2C7126F940B9049FCC7E2EBAFC4F7550B8899BD995957EF4F2CF2B316D991E437D0579C9BD5516DCEB12BE9FF3F21B1832210ECD2BE5BA6777FC8D24186375C13314649DB9AA794E5F9E0B18442992697787F744F93AE9C37140D8ED2D0E9A9066A3FBA3501BF4BEC278A578F60FB31A8B13A3C4A6A3E06B17D056319EF4B52131459BEB376BD988EB23C52EC1610CCCBD07FF07379CBA48951AF47FA850D641BA6502D029F870ABE84");
        certs.put("852DF7A70A512D83103DFBC9F628CB6B1CEE5591","308206843082046CA003020102020812F2438F96F2EC10300D06092A864886F70D01010505003081853122302006035504030C194974616C69616E20436F756E747279205369676E657220434131333031060355040B0C2A4E6174696F6E616C20456C656374726F6E69632043656E746572206F6620537461746520506F6C696365311D301B060355040A0C144D696E6973747279206F6620496E746572696F72310B3009060355040613024954301E170D3136303531383133323135395A170D3331303831333133323135395A3081853122302006035504030C194974616C69616E20436F756E747279205369676E657220434131333031060355040B0C2A4E6174696F6E616C20456C656374726F6E69632043656E746572206F6620537461746520506F6C696365311D301B060355040A0C144D696E6973747279206F6620496E746572696F72310B300906035504061302495430820222300D06092A864886F70D01010105000382020F003082020A0282020100D4B7B29AD7C995E4A3430610C583CB79B2AD42BABEE92A18BDBD277969B8DE00F39803D083116F785AC9FE4F30E5B2AC64A67E39704B15C355A077866E1D2B6641306A83DC7E313C31ABF784839588BDAEACDDA690324F83F1C113ABB7CB72906323250299C6E5005249646B4844FAD1E57A2926EA35C5899E86F78AB342E49D94B0E25EA3B969DC769092C5F422070DA64B23204AE8D7CACCD005401A4E5879FBA9A9402CB2D797CF4E804DEEBD5A1AEACEB04B18D48D7A1E869D92474FF72829DE52036E10307DE992D27931BD8086EFEA7D3AB7038DB34685D5E335B647A43FD5B60E429834F167A7819F5D706D90915ACF272FEABD44299D6FADCEA6B3A83A557BCEDBFCB73690700CDF7ACBFB1003619CEC7B849A55C16BAB020C9C3C04CD31FBFE71DD8DA648227E412231E4D359EE40A3DBE494E1B875B01717099F3B4D7AB7B812B07AA475D7CCD53AD79A44EE5B92E775CD3A205144618708F9E7CF11B31813ADDE289ED4CBC913CC72C14931EE92E8B0A517775EBC3E19150D0AEED2B9009B540D22CCC338674522DF6C0A48F6AA25B9475A59F1DA2AAAB0FD93D5F3DC986A91A95B5147EE46EAD5A1175E7E90B5892489F8A0FDDEF2E3FFE17046F45215F5E192CDC55F44F5C762B94F20958C9E3FB9B12059034A875407359CD920188FB9178D9925A4B501D2924F547EE4385FB5642A0EC42547C18E97C55C690203010001A381F53081F2301D0603551D0E04160414852DF7A70A512D83103DFBC9F628CB6B1CEE559130120603551D130101FF040830060101FF020100301F0603551D23041830168014852DF7A70A512D83103DFBC9F628CB6B1CEE5591304C0603551D1F044530433041A03FA03D863B687474703A2F2F637363612D6974612E696E7465726E6F2E676F762E69742F6365727469666963617469435343412F43524C5F435343412E63726C300E0603551D0F0101FF040403020106303E0603551D1104373035811373706F632D69746140696E7465726E6F2E6974861E687474703A2F2F637363612D6974612E696E7465726E6F2E676F762E6974300D06092A864886F70D010105050003820201007C94718AB0BBC7D4F6A999DDB82320C12D2652EB42AC1A7B1E5847CD1AB613E83F9B601C9041135F7FA6E788F828705281044089E19F0C0143D4DE1A1BCBA4CAF160799741646A6D4ABDD16944A094D090DCE854207274DCE30710CDC38F46FF943E4FD86946E1F51D9A0EC4938FC9BC3BEDC6B8FA747EC5FCF7BF4F3BDDB4415941FCAE1640DA330EBB751C2A5DDB2B5375C0FBC8DF47C190DCEF4E191FB3CACBAB279F340FAB591188CC7ED13E9264C92DFD4C9D82FEB246CF6979FF3B0BC80AE69DCF9FBCFDCB959CA86663E473DA93DEE60DF52552A0158659BD32389BF1AC6B6AB06F7A21A4EB8A21BCE2EF36D203BA4FE49CEB706BB069BB4A4935573F4F210082271536D8BAFBBC6EEAF98B02BB9244DB334E35F4A94EACAEF4BC29F866D4484F92BBEF683C144D4B09E6D7921ECE8A78A928C228954423ABC2199C948A696B9FF47067EA71F372860FDBA25396E9FEEA8D07CB2520BD01CCA27E9F780DE245D4D8EC6FB91B54E374514751343A02258038A4C037F826DF25E01CBC486F2F590A6921314DFB23CDB09A00905E1B52173309CCB4FEA3E9F65E921C86F1F815989E97F8824BD097781104D95EAA6A2E20E5F4C70A9D9657FBE248FD1C4705801F17A4F99EA3F587C710F3F887DFCA7985BA15927B49134586A3D6347B804C67FF82337C39C4F1C6912FCE8A78BD0658998EAB0C51FDC6C6F7221D57BDDD");
        certs.put("A0F56552180CCBCC0FFD7D0DF39F8604C7C98F62","3082059B30820383A003020102020101300D06092A864886F70D0101050500305D310B3009060355040613024954311F301D060355040A13164D494E49535445524F2044454C4C27494E5445524E4F310B3009060355040B130250453120301E0603550403131743455254494649434154494F4E20415554484F52495459301E170D3036313032333134303334345A170D3232303131373134303334345A305D310B3009060355040613024954311F301D060355040A13164D494E49535445524F2044454C4C27494E5445524E4F310B3009060355040B130250453120301E0603550403131743455254494649434154494F4E20415554484F5249545930820222300D06092A864886F70D01010105000382020F003082020A0282020100B6A68582193ECAE1E0F60F95779C21CAA97E299A5A6AEF1281ADB04B16E322B9781E1B2817D8F5873AE08652ABB2263757FB04BA9F95F54DB03F3D2D2ACDAD110AD7703B838ABABEB2BA4C34865D9FD797BE985C5447C3CFACA4BCD098C0F5D9F16166BCE14B3C021B6725F1DAC0D6B8B4E0E6A867CEAFD051363C93A99BD937BEF4FD7994356211838D727DC3A8030B8A25B65CCDB51CA5AED8AF96800460B10A88AEAE767F47317783D35CD2555D8BCD8E53CD145F0314028F88CED0A017B60A6A4001E214E4B44077E31C31C3131B80132C0ABED50CE0B46F333E8A9CF3282CB687CA9C6D1303A68C5A00327D0CC4988D39DF18401444183DB603CC78674605C1F2BE99EC8F7344C53A99BB949E688736D6D2F2AAE4BCFC0AFA556636F036431DB97664CC18F0A36B8CC8934EB69968DBB42745B46AAE99F07468F15A60641A3726388437AC5CF5C784B60795D94732F15B9B9D85CA00BBA56CCE24E4F10764894764EC11E2AF084A34A33068A2E0625DBA466CD8BEED8EF9F5C33D6D654A8F2BC3C70170FBCED26FA35101BBC4417232FD51FBEAF6D778A40E6381692354239C7867CFD4855A827F7AD502DD629176C81AE37ACB74F2CD66432985C073AC49BC60C0A853F1767DCFBDC8CF41C30B63DC42A8F18B89D84DF6BF6F17671C567C8B0525F846430F3FDC960CE4E59F59ED61D703ACC16592EF1155DD832EF7F70203010001A366306430120603551D130101FF040830060101FF020100301D0603551D0E04160414A0F56552180CCBCC0FFD7D0DF39F8604C7C98F62301F0603551D23041830168014A0F56552180CCBCC0FFD7D0DF39F8604C7C98F62300E0603551D0F0101FF040403020106300D06092A864886F70D0101050500038202010041228CA62684BAC9CE8B85BF0EDD1D37BEBD9AD6BD9631A96E340D192BF9EB80E08066337EE28C744891C80DD07D66410A0D0DE158446F0448216D3DD6CD51C94F1EFDC000C09BE2818F1EDA83B09D3CE0832CF6841FED02A42F4FF8702ACE0303D045EAEEBEEDCB7A5F575F3C5A46D71955859253A117F15BD05B4E1E6B193744B9226DF680E7E9A6429B16141B96B0EB2C2A3E616EF4A22D436CA59A81B2102104AE7272388D235457C88C8C333B3D2918B4AD7EDE66D8007E897EC709995A9FB6D5AFAE088EEB0B867EE8CB0C34574824340D190EED96A9586D0D958AC56D42929145A18DDBD5E4069620F9BE7DF991612A630EFE6E9439AD07BF6AE324B502BAE7FCA4CD86B842C83253B80A833780A7E5E53F2E75CC7F4B010C2EDEEC8B8C057AB2FE61B6EED107DFAA379F6B35F583F8D4D42A61F75ED77F0143DFC5878D05148A8D92CFB6A63F894DE81748A7DD4A1B09165BAEE1A249034EB32905C2B2956801CAAD12999D63611E7523015E9CBB5A760B7A402F2AE61CEAD03B449553B31E97973B27568C252C163498D506806BE9ECAD1A4CF4F6A568F7A2FFB3AC73534E909DDE89120C0B4EC6FFB3EF05DA073650D4EA7CCD863198B5364B14D6DFC2B74D8477BD61FC0CF8CDD3A3E517F8E825D9BC5DA6C484F4F7FA15D2ECF737F7122EBF0CAE7478DDE515AAF271094A527BF13EEADA9FBEAE186AE913BF64");
        certs.put("B0BF3BB9ECEBC720974C1D13A5905A1A613589A0","308205A130820389A003020102020101300D06092A864886F70D01010505003060310B3009060355040613024954311F301D060355040A13164D494E49535445524F2044454C4C27494E5445524E4F310B3009060355040B13025045312330210603550403131A43455254494649434154494F4E20415554484F52495459203031301E170D3131313231343130323930345A170D3237303331303130323930345A3060310B3009060355040613024954311F301D060355040A13164D494E49535445524F2044454C4C27494E5445524E4F310B3009060355040B13025045312330210603550403131A43455254494649434154494F4E20415554484F5249545920303130820222300D06092A864886F70D01010105000382020F003082020A0282020100C65EC3C9465320DC795071E65350F3A760C274273290B6BEBF001FE07B6534FB4C1EC3C53145D7ED19FFC14A47B71F07CF7FECF1C73DED6D013A3137DD7A49072ADD1870B66D0B589D8FADA35999C3AA885119EE0084E73961E6A84FD9EF2FF56991FE49FCA29128700919925665356A2D579E10C768B1DC120E3A5EBDFF9EEBA45A7C90DCB0861F184DF040BA2999B4C316BDE69BD365EAD292AC99EC37A05EA0C4D4B3912BA2C24E8C0385AF1D8E22A27C491CEE434630B3326FF2EF1ACFF70A7682F91E999EAB674957AEEEBBD7D97AAEF5931EED922247500B4C21DDB8FC79A34390149E662945B3468213BC4F4F5619C044D25F05FF9FFA23C41D4B51B9F647EB5CAA975D63E799F681BFC516F539599AA2BD1FB305B207624C14C15D6E4298F5C7210A7DC5508A2743F4B72265AC49CC569ECB8775E2545E8EBC1682A3BFD60CBCAEA140F99496DFCDB69786EE5F75F05D76DFA3907256FF939EDC5E2ECDD3E4941A9DB04DDC7234E3E40E51E162A4B0F741C07CA6136E1109A8E45ECBFC3C0F59C23AB830029FB15AB5A60200EE6546FF3792335C072777F8FE2DDC02C7416F7C2C00B732E23441B539942DAD32E775EDFD8E66D582EBF7E16B3377E53C48DF1D5D09393C3C62BECA0CA54F619435D2E942BEDAF98754DEA66F4E8EA6BB0CB87931CBFB153B069CFE6F0A2A965DF92DB305C534E47C6CB22C1FF1D9610203010001A366306430120603551D130101FF040830060101FF020100301D0603551D0E04160414B0BF3BB9ECEBC720974C1D13A5905A1A613589A0301F0603551D23041830168014B0BF3BB9ECEBC720974C1D13A5905A1A613589A0300E0603551D0F0101FF040403020106300D06092A864886F70D010105050003820201002F863189869F1AD1ACD4934C6545F56AFDF41008AFBF1C6B87E1E808852D5D1FD08FB02DBB545CCA8660EFB270615D00A30C5F7C24F0C43A6673739B2EBEDAA9DAC8FA84A40F646EAAFD3C81977AA2AB18A9E56662A6D69E54CCF1F2EC88E93C90DEDA9B54473D339E2861529252047E1AD7BC18A989EC233E4A766A2653F5475240DB470A210D964BA28B72494DFE3085FBD4F5BCD4BCE23DD5ACFFEFF10E37A17467DEB8E9F67224187093ACE3850F362B5E8B1486DF5B4F0074393097012BBD4E359DD1FA6867A6928910E1E77790FC512C589A40A9DCFC41155439E78253C4B760C71D8213AF6771C0FC29A416C8DFE41C34597E6ADA3066E19BC16EB25850BA889F4D9C7E865F8555941F3C9C5D307DCF2A89518BE9F0759117ECBD52CC6277CFE07E93DE9574F63DBA57DD46A455687227A970D9185E00169FDCD113F18B88D6C3F91A10E3040A0BF2285ED934F99EBDCC19A3C984760C1B41E8ED74D77681890B0D0DBA8A23F2E7762818BC29D1E5ADC6679C4F51DF7EF54991FBFD42ED50A6AD99DD242401360B4B4F2E00C8898D10A14BCC27A88D7E5629ABDACF3DEC7D69F6C0615B03D54981EBD31EFCCCFB74B2C1B8180096AD7E5328DE1355B60D4861B0AA08B401A6CDB4C332AE0A8A95596AAEFAB1E6590C925E4C81F03F67DD679115FF2269971BD2B53DECB2C400A8DFA51690E02D998A2D4C25583C6430");
        certs.put("D11A505E15ADEA5A61779CA4A2A991EC3949D1F9","3082079A3082054EA00302010202083D401E98CABBADDA304106092A864886F70D01010A3034A00F300D06096086480165030402030500A11C301A06092A864886F70D010108300D06096086480165030402030500A2030201403081903122302006035504030C194974616C69616E20436F756E747279205369676E6572204341313E303C060355040B0C354E6174696F6E616C20456C656374726F6E69632043656E746572206F66204974616C69616E204E6174696F6E616C20506F6C696365311D301B060355040A0C144D696E6973747279206F6620496E746572696F72310B3009060355040613024954301E170D3230303432393039333034335A170D3335303732353039333034335A3081903122302006035504030C194974616C69616E20436F756E747279205369676E6572204341313E303C060355040B0C354E6174696F6E616C20456C656374726F6E69632043656E746572206F66204974616C69616E204E6174696F6E616C20506F6C696365311D301B060355040A0C144D696E6973747279206F6620496E746572696F72310B300906035504061302495430820222300D06092A864886F70D01010105000382020F003082020A0282020100AD249DB0AC7E6BCAC3673EF6403393D9864613783F295061620CB334046A1E9E7528CFD1AFFD3647BD6BD1BA96C616C770A5C135AF9BF739E9E2D9B676CB673C9943594FC2C84CC4AA8DBF33BE385658E6924631191DCFD60D979F7145359983AA6BE0B5EEE93E6F56810C51852B6A2EB542265D45C8E83DC28160B7A2E098A9378DB5FB83B253BC1941CB5E3B4C0B2A691262A9156CFBE6BAE5D6045268803D3A0662F8E04506714598FCB06EEA0A74C3E8563344EA70C04173E7DA5E64CC6B2AFFDED0164705228C18609EB1EC7040D8F6BF710758EB5B86A7FB9E3212283185CA8E428EDD0AC9A6D5FA46A5F7BED78A32ACDDFB723D4BE5A9F1AAA476749064262DF6548E0CDEFC00E7367F7B15884A276F61D44CBF59AC36561BB51D29FFC3BF90A8FEB8D09A279DD5F670EFFE5739B1FD401936CAE6C5B9848AF86F8202190E65FC47FCA2A1F6CF9518E37754D95CE8C6931C6CF99DF238820FFC7C509F502E87F94D3342D85389B264F540C5ADBE6FDDBE9651994F3B4D0B5C7CB7B100F2058BE8D8C65C2B590B29F58247834DAD8EDF6FEE6D4C97910A8432B95723AF817CEE1860AF7332AF37C7DF0CFA6AA1312F6A385CDCB6682EC6CC84F84A5AAD99F3AF5FC876B1B263E968200A95E0A1D039ABCB696CBDB2A67A6F49A1C775338B907CB073AA8777899A10A1B35736D10809E82A9806335554ECCE64319030DB0203010001A382018C3082018830120603551D130101FF040830060101FF020100301F0603551D23041830168014D11A505E15ADEA5A61779CA4A2A991EC3949D1F930520603551D12044B3049811373706F632D69746140696E7465726E6F2E6974A410300E310C300A06035504070C03495441862068747470733A2F2F637363612D6974612E696E7465726E6F2E676F762E69742F30520603551D11044B3049811373706F632D69746140696E7465726E6F2E6974A410300E310C300A06035504070C03495441862068747470733A2F2F637363612D6974612E696E7465726E6F2E676F762E69742F304D0603551D1F044630443042A040A03E863C68747470733A2F2F637363612D6974612E696E7465726E6F2E676F762E69742F6365727469666963617469435343412F43524C5F435343412E63726C301D0603551D0E04160414D11A505E15ADEA5A61779CA4A2A991EC3949D1F9302B0603551D1004243022800F32303230303432393039333034335A810F32303234303432383039333034335A300E0603551D0F0101FF040403020106304106092A864886F70D01010A3034A00F300D06096086480165030402030500A11C301A06092A864886F70D010108300D06096086480165030402030500A2030201400382020100253B3A99A1B2293B956EC6A8C982513CC160BC514CD45835EB30A1CF262F08F91BE7AFAA198929BC74EBA2C5FC3F603B40F9E86EB56A7B7854DC35D125C7FB38F78B2754C30A643D530B117AB25DDF88E767DE479B8EF30B6777F028E87936707DC6B67F2C182892B3A56BBB60DD842F32DB74CBB316B35A62280117102E7C97F0186831B1DCAD7A791AC3D0584918FE24E69EA99D6974735013A267C6F220E979228324F2854B17DCCB7BC7EE02C77CE7247027D5F2F0F8E00468CE77028D27952521A21567C307D2E9C94F4AA4C407388BFAEF642C03060E1FE8AE7873CD5563FDCD7F683322E492DD39FA11BFD4EAD0E5B5872A2AFFCF8D11E7B90A104FA0491D31F5F08D4515171C6625C35839B023B026133D866E1B7FC93CD71D67075F3433B2E2F7D0D85305A30F88219D63C26CB4867212AA1861C115ECFB9C9FF58944704105DA344507CF2B509F608BF209A13A6654615AADEAE4B22A3B4FCD45D4113DA6C489C8B1363061E415E4B00A5CCD6E21DFAAF13A57987C349A85B1A3A878996AFAA2354B574D10284E33674F01C51F0A133AC53396BE70384DD3A0EECED0B331B1BD7F3F32A702C3468D976D573489FE651648867EDCC87A93A1960A1DE1A8EC15F93B25C8A7A41EFFE9941856AF109BFD5D135A163B13B92E5F50017ED4BF41DACC205DFC3A426294406533311853D962DAF8C9E21975DA7ACD8C9417");
    }

    public String getCsca(String serialId){
        if(certs == null)
            loadCertsCSCA();
        return certs.get(serialId);
    }

    public static String getX509CertificateInfo(X509Certificate certificate){
        String certReturn = "";
        certReturn =  certReturn + ("Algoritmo: " + certificate.getSigAlgName()) + " \n";
        certReturn =  certReturn + ("OID: " + certificate.getSigAlgOID()) + " \n";
        certReturn =  certReturn + ("tipo certificato: " + certificate.getType()) + " \n";
        certReturn =  certReturn + ("Numero versione: " + certificate.getVersion()) + " \n";
        certReturn =  certReturn + ("Data scadenza: " + certificate.getNotAfter()) + " \n";
        certReturn =  certReturn + ("Data emissione: " + certificate.getNotBefore()) + " \n";
        certReturn =  certReturn + ("S/N: " + certificate.getSerialNumber()) + " \n";
        X500Principal x500PrincipalIssure = certificate.getIssuerX500Principal();
        X500Principal x500PrincipalSubject = certificate.getSubjectX500Principal();
        certReturn =  certReturn + ("Issure: " + x500PrincipalIssure.getName()) + " \n";
        certReturn =  certReturn + ("Subject: " + x500PrincipalSubject.getName()) + " \n";
        return certReturn;
    }

}
