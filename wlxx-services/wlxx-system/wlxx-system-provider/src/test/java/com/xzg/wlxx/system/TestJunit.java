package com.xzg.wlxx.system;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;
import java.util.stream.Stream;


/**
 * @author xzgang0499
 * @date 2022-04-14
 * @since jdk1.8
 */
@SpringBootTest
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestJunit {

    private final Faker faker = new Faker(Locale.CHINA);


    @ParameterizedTest
    //@ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
    @ArgumentsSource(MyArgumentsProvider.class)
    void palindromes(String candidate) {
        log.info("====={}", candidate);
        log.info("={}=", faker.name().fullName());
    }

    static class MyArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of("1", "2").map(Arguments::of);
        }
    }

}
