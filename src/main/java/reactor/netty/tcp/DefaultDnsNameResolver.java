package reactor.netty.tcp;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

public class DefaultDnsNameResolver implements DnsNameResolver {

  @Override
  public Optional<InetAddress> resolve(String hostname) {
    try {
      return Optional.ofNullable(InetAddress.getByName(hostname));
    } catch (UnknownHostException e) {
      return Optional.empty();
    }
  }
}
