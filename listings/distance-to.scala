import FieldCalculusLibrary.share
import CommonLibrary.mux

object GradientLibrary:
  def distanceTo[N: Numeric: UpperBounded](
    using language: AggregateFoundation & FieldCalculusSyntax & DistanceSensor[N],
  )(source: Boolean): N =
    share[N](summon[UpperBounded[N]].upperBound)(av =>
      mux(source)(
        summon[Numeric[N]].zero
      )(
        distanceEstimate(av)
      )
    )
