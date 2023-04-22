@Service
public class DonationService {

  private final DonationRepository donationRepository;

  public DonationService(DonationRepository donationRepository) {
    this.donationRepository = donationRepository;
  }

  public List<Donation> findAll() {
    return donationRepository.findAll();
  }

  public Optional<Donation> findById(Long id) {
    return donationRepository.findById(id);
  }

  public Donation save(Donation donation) {
    return donationRepository.save(donation);
  }

  public void deleteById(Long id) {
    donationRepository.deleteById(id);
  }
}
