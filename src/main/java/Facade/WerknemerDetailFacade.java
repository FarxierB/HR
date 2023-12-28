package Facade;

import configuration.JPAConfig;
import entity.WerknemerDetail;
import repository.DetailRepo;

public class WerknemerDetailFacade {
    private final DetailRepo werknemerDetailRepository;

    public WerknemerDetailFacade() {
        this.werknemerDetailRepository = new DetailRepo(JPAConfig.getEntityManager());
    }

    public WerknemerDetail createWerknemerDetail(WerknemerDetail werknemerDetail) {
        return werknemerDetailRepository.createWerknemerDetail(werknemerDetail);
    }

    public WerknemerDetail updateWerknemerDetail(WerknemerDetail werknemerDetail) {
        return werknemerDetailRepository.updateWerknemerDetail(werknemerDetail);
    }

    public WerknemerDetail deleteWerknemerDetail(WerknemerDetail werknemerDetail) {
        return werknemerDetailRepository.deleteWerknemerDetail(werknemerDetail);
    }


}
