package com.github.marschall.psychicsignatures;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

import org.junit.jupiter.api.Test;

class PsychicSignaturesTests {

  @Test
  void verify() throws GeneralSecurityException {
    KeyPair keys = KeyPairGenerator.getInstance("EC").generateKeyPair();
    byte[] blankSignature = new byte[64];
    Signature signature = Signature.getInstance("SHA256WithECDSAInP1363Format");
    signature.initVerify(keys.getPublic());
    signature.update("Hello, World".getBytes());
    assertFalse(signature.verify(blankSignature), "blank signature should not be valid");
  }

}