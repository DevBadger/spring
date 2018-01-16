package flexsecurity.service

import com.devbadger.security.exception.SecurityAuthorizationException
import com.devbadger.security.service.SecurityValidationService
import com.devbadger.security.service.SecurityValidationServiceImpl
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import spock.lang.Specification

/**
 * @author Robert Volker (robert.volker@consensuscorp.com)
 * @since 11/8/17.
 * <p>
 * All rights reserved. (C) Consensus Corporation
 */

class SecurityValidationServiceImplSpec extends Specification{

    public static final String TEST_SECRET = "test-secret"
    public static final String TEST_SESSION_ID = "123-123-123-123"
    public static final String TEST_STORE_ID = "667"
    public static final String TEST_REP_ID = "8048"


    def "testCanValidateJWT"() {

        given:
        Claims claims = Jwts.claims()
        claims.put("sessionId", TEST_SESSION_ID)
        claims.put("storeId", TEST_STORE_ID)
        claims.put("repId", TEST_REP_ID)

        String jwt = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, TEST_SECRET.bytes)
                .compact()

        println(jwt)


        when:
        SecurityValidationService service = new SecurityValidationServiceImpl(secret: TEST_SECRET)
        def flexUser = service.validateAndReturnFlexUser(jwt)


        then:
        assert claims.entrySet().size() == 3
        println "Claims count " + claims.entrySet().size()

        assert flexUser.sessionId == claims.get("sessionId")
        println claims.get("sessionId")

        assert flexUser.storeId == claims.get("storeId")
        println claims.get("storeId")

        assert flexUser.repId == claims.get("repId")
        println claims.get("repId")
    }

     def "testWithNullJWT"() {
        given:

        String jwt = null

        when:
        SecurityValidationService service = new SecurityValidationServiceImpl(secret: TEST_SECRET)
        service.validateAndReturnFlexUser(jwt)

        then:
        thrown(SecurityAuthorizationException)
    }


    def "testJWTCreatedWithBadSecret"() {
        given:
        Claims claims = Jwts.claims()
        claims.put("sessionId", TEST_SESSION_ID)
        claims.put("storeId", TEST_STORE_ID)
        claims.put("repId", TEST_REP_ID)

        String jwt = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "make-jwt-invalid-with-bad-secret".bytes)
                .compact()

        when:
        SecurityValidationService service = new SecurityValidationServiceImpl(secret: TEST_SECRET)
        service.validateAndReturnFlexUser(jwt)

        then:
        thrown(SecurityAuthorizationException)
    }
}
