@Repository
public class DonationRepository {

  private final Map<Long, Donation> donations = new ConcurrentHashMap<>();
  private Long nextId = 1L;

  public List<Donation> findAll() {
    return new ArrayList<>(donations.values());
  }

  public Optional<Donation> findById(Long id) {
    return Optional.ofNullable(donations.get(id));
  }

  public Donation save(Donation donation) {
    if (donation.getId() == null) {
      donation.setId(nextId++);
    }
    donations.put(donation.getId(), donation);
    return donation;
  }

  public void deleteById(Long id) {
    donations.remove(id);
  }
}
