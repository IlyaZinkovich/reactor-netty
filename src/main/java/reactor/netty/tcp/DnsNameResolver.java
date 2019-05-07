package reactor.netty.tcp;

import java.net.InetAddress;
import java.util.Optional;

public interface DnsNameResolver {

  Optional<InetAddress> resolve(String hostname);
}
