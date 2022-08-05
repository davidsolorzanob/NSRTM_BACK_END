package com.nsrtm.contribuyente.microservice.util;

public class Catalogo {
    public static final int TipoDocumento =1;
    public static final int TipoContribuyente =2;

    public class Maestro {
        public final class TipoDomicilio {
            public static final int Fiscal = 1;
            public static final int Real = 2;
            public static final int Procesal = 3;
            public static final int Otros = 4;
        }
        public final class TipoDocumentoIdentidad {
            public static final int Dni = 1;
            public static final int Ruc = 2;
            public static final int Pasaporte = 3;
            public static final int Ce = 4;
        }
    }
}
