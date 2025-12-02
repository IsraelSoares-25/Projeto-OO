package service;

import Exceções.PagamentoRecusadoException;

public abstract class PagamentoService{
    public abstract boolean processarPagamento(double valor) throws PagamentoRecusadoException;
    }
