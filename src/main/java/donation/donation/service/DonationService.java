public class DonationServiceImpl implements DonationService {
  private DonationRepository donationRepository;
  
  // Constructor
  public DonationServiceImpl(DonationRepository donationRepository) {
      this.donationRepository = donationRepository;
  }
  
  @Override
  public Donation findById(Long id) {
      return donationRepository.findById(id);
  }

  @Override
  public List<Donation> findAll() {
      return donationRepository.findAll();
  }

  @Override
  public void save(Donation donation) {
      donationRepository.save(donation);
  }

  @Override
  public void update(Donation donation) {
      donationRepository.update(donation);
  }

  @Override
  public void deleteById(Long id) {
      donationRepository.deleteById(id);
  }
}

