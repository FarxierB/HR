package Service;

import configuration.JPAConfig;
import entity.WerknemerDetail;
import repository.DetailRepo;

public class DetailService {
    private DetailRepo werknemerDetailRepository;

    public DetailService() {
        this.werknemerDetailRepository = new DetailRepo(JPAConfig.getEntityManager());
    }

    public WerknemerDetail createWerknemerDetail(WerknemerDetail werknemerDetail){
        return werknemerDetailRepository.createWerknemerDetail(werknemerDetail);
    }



    public WerknemerDetail updateWerknemerDetail(WerknemerDetail werknemerDetail) {
        return werknemerDetailRepository.updateWerknemerDetail(werknemerDetail);
    }

    public WerknemerDetail deleteWerknemerDetail(WerknemerDetail werknemerDetail) {
        return werknemerDetailRepository.deleteWerknemerDetail(werknemerDetail);
    }
}
