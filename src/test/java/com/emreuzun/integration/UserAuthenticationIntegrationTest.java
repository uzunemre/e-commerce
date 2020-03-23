package com.emreuzun.integration;

import com.emreuzun.config.WebSecurityConfigurationAware;
import org.junit.Test;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

public class UserAuthenticationIntegrationTest extends WebSecurityConfigurationAware {

    private static String SEC_CONTEXT_ATTR = HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

    @Test
    public void requiresAuthentication() throws Exception {
        mockMvc.perform(get("/category/"))
                .andExpect(redirectedUrl("http://localhost/login"));
    }
}
