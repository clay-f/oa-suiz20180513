package com.f.api;

import com.f.controller.AbstractController;
import com.f.core.pojo.Dict;
import com.f.services.impl.AbstractGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DictController extends AbstractController<Dict, Long> {
    @Autowired
    public DictController(@Qualifier(value = "dictService") AbstractGenericService abstractGenericService) {
        super(abstractGenericService);
    }
}
