package org.example.generators;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.util.UUID;

public class CustomGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        int code = UUID.randomUUID().hashCode();
        if (code > 0) {
            return code;
        } else {
            return -1 * code;
        }
    }
}
