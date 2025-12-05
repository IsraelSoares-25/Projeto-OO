package service;

import Exceções.PagamentoRecusadoException;
import Exceções.SaldoInsuficienteException;

public abstract class PagamentoService{
    public abstract boolean processarPagamento(double valor) throws PagamentoRecusadoException, SaldoInsuficienteException;
    }
