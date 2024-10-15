package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue
    private long portfolioId;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Security> securities;

    protected Portfolio() {
    }

    public Portfolio(Client client) {
        this.client = client;
    }

    // Getters and Setters

    public Long getPortfolioId() {
        return portfolioId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(Set<Security> securities) {
        this.securities = securities;
    }
}