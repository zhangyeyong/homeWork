package com.paascloud.provider.model.service.hystrix;


import com.github.pagehelper.PageInfo;
import com.paascloud.base.dto.MessageQueryDto;
import com.paascloud.base.dto.MqMessageVo;
import com.paascloud.provider.model.service.UacMqMessageFeignApi;
import com.paascloud.wrapper.Wrapper;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * The class Uac mq message api hystrix.
 *
 * @author paascloud.net @gmail.com
 */
@Component
public class UacMqMessageApiHystrix implements UacMqMessageFeignApi {

	@Override
	public Wrapper<List<String>> queryMessageKeyList(final List<String> messageKeyList) {
		return null;
	}

	@Override
	public Wrapper<PageInfo<MqMessageVo>> queryMessageListWithPage(final MessageQueryDto messageQueryDto) {
		return null;
	}

}
