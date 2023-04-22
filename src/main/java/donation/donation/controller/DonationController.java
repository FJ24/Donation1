@RestController
@RequestMapping("/donations")
public class DonationController {

  private final DonationService donationService;

  public DonationController(DonationService donationService) {
    this.donationService = donationService;
  }

  @GetMapping
  public List<Donation> findAll() {
    return donationService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Donation> findById(@PathVariable Long id) {
    return donationService
      .findById(id)
      .map(ResponseEntity::ok)
      .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Donation> create(@RequestBody Donation donation) {
    Donation savedDonation = donationService.save(donation);
    URI location = ServletUriComponentsBuilder
      .fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(savedDonation.getId())
      .toUri();
    return ResponseEntity.created(location).body(savedDonation);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Donation> update(
    @PathVariable Long id,
    @RequestBody Donation donation
  ) {
    Optional<Donation> existingDonation = donationService.findById(id);
    if (existingDonation.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    donation.setId(id);
    Donation updatedDonation = donationService.save(donation);
    return ResponseEntity.ok(updatedDonation);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    Optional<Donation> existingDonation = donationService.findById(id);
    if (existingDonation.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    donationService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
