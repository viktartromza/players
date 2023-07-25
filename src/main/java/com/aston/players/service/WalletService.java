package com.aston.players.service;

import com.aston.players.model.domain.User;
import com.aston.players.model.domain.Wallet;
import com.aston.players.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    private final WalletRepository walletRepository;

    @Autowired
    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWalletForUser (User user){
        Wallet wallet = new Wallet();
        wallet.setUser(user);
        wallet.setBalance(0.00);
        return walletRepository.saveAndFlush(wallet);
    }
}
