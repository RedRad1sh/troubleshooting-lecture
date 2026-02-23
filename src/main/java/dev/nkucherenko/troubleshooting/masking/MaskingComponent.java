package dev.nkucherenko.troubleshooting.masking;

import dev.nkucherenko.troubleshooting.config.MaskingConfig;
import dev.nkucherenko.troubleshooting.config.MaskingObj;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RegExUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author nkucherenko
 */
@Component
@RequiredArgsConstructor
public class MaskingComponent {
    private final MaskingConfig maskingConfig;

    public String maskInfo(String info) {
        List<MaskingObj> replaceArr = maskingConfig.getReplaceList();
        for (MaskingObj maskingObj : replaceArr) {
            String regexString = maskingObj.getRegex();
            String replaceString = maskingObj.getReplace();
            info = RegExUtils.replaceAll(info, regexString, replaceString);
        }
        return info;
    }
}
