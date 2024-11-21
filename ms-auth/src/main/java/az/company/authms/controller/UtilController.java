package az.company.authms.controller;

import az.company.authms.service.AuthorizationHelperService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
public class UtilController {
    private final AuthorizationHelperService service;

    @GetMapping("/{auth}")
    public String fin(@PathVariable String auth) {
        return  service.getFin(auth);
    }
}
