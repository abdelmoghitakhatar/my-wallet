package com.myapp.floosy.service;

import com.myapp.floosy.dao.OperationRepository;
import com.myapp.floosy.dao.WalletRepository;
import com.myapp.floosy.model.Operation;
import com.myapp.floosy.model.Wallet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {

    private final WalletRepository walletRepository;
    private final OperationRepository operationRepository;

    public WalletService(WalletRepository walletRepository, OperationRepository operationRepository) {
        this.walletRepository = walletRepository;
        this.operationRepository = operationRepository;
    }

    public List<Wallet> getAllStates(){
        return walletRepository.findAll();
    }

    public Wallet getCurrentState() {
        return walletRepository.findFirstByOrderByIdDesc();
    }

    public Wallet saveNewWallet(Operation operation){

        Wallet newWallet = new Wallet();
        Wallet wallet = getCurrentState();

        switch (operation.getOperation()){
            case in:
                newWallet.setRest(wallet.getRest() + operation.getMontant());
                break;
            case out:
                newWallet.setRest(wallet.getRest() - operation.getMontant());
                break;
            default: break;
        }

        operationRepository.save(operation);
        return walletRepository.save(newWallet);
    }


}
