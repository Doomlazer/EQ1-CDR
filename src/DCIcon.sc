;;; Sierra Script 1.0 - (do not remove this comment)
(script# 967)
(include sci.sh)
(use DIcon)
(use Cycle)


(class DCIcon of DIcon
	(properties
		type $0004
		state $0000
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
		view 0
		loop 0
		cel 0
		cycler 0
		cycleSpeed 6
		signal $0000
	)
	
	(method (init)
		((= cycler (Fwd new:)) init: self)
	)
	
	(method (dispose)
		(if cycler (cycler dispose:))
		(super dispose:)
	)
	
	(method (cycle &tmp theCel)
		(if cycler
			(= theCel cel)
			(cycler doit:)
			(if (!= cel theCel) (self draw:))
		)
	)
	
	(method (lastCel)
		(return (- (NumCels self) 1))
	)
)
