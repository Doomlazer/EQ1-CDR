;;; Sierra Script 1.0 - (do not remove this comment)
(script# 950)
(include sci.sh)
(use Main)
(use PolyPath)
(use Obj)


(class CueObj of Script
	(properties
		client 0
		state $ffff
		start 0
		timer 0
		cycles 0
		seconds 0
		lastSeconds 0
		ticks 0
		lastTicks 0
		register 0
		script 0
		caller 0
		next 0
		theVerb 0
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(1
				(gEgo
					setHeading:
						(GetAngle (gEgo x?) (gEgo y?) (client x?) (client y?))
						self
				)
				(gTheDoits add: self)
			)
			(2 (= cycles 3))
			(3
				(gTheDoits delete: self)
				(if
					(not
						(if (and client (IsObject (client actions?)))
							((client actions?) doVerb: theVerb)
						)
					)
					(client doVerb: theVerb)
				)
				(= state 0)
			)
		)
	)
)

(class Feature of Obj
	(properties
		x 0
		y 0
		z 0
		heading 0
		noun 0
		modNum -1
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		sightAngle 26505
		actions 0
		onMeCheck $6789
		approachX 0
		approachY 0
		approachDist 0
		_approachVerbs 0
	)
	
	(method (init param1)
		(self initialize: (if argc param1 else 0))
		(if (self respondsTo: #underBits)
			(gCast add: self)
		else
			(gFeatures add: self)
		)
	)
	
	(method (dispose)
		(if actions (actions dispose:) (= actions 0))
		(if (IsObject onMeCheck)
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(gFeatures delete: self)
		(super dispose:)
	)
	
	(method (initialize param1)
		(cond 
			((and argc param1) (self perform: param1))
			(gEcoFtrInit (self perform: gEcoFtrInit))
		)
	)
	
	(method (handleEvent pEvent)
		(cond 
			((pEvent claimed?) (return 1))
			(
				(and
					(& (pEvent type?) evVERB)
					(self onMe: pEvent)
					(self isNotHidden:)
				)
				(CueObj
					state: 0
					cycles: 0
					client: self
					theVerb: (pEvent message?)
				)
				(pEvent claimed: 1)
				(if
					(and
						(gUser canControl:)
						(>
							(GetDistance (gEgo x?) (gEgo y?) approachX approachY)
							approachDist
						)
						gEcoApproachCode
						(&
							_approachVerbs
							(gEcoApproachCode doit: (pEvent message?))
						)
					)
					(gEgo
						setMotion: PolyPath approachX (+ (gEgo z?) approachY) CueObj
					)
				else
					(gEgo setMotion: 0)
					(if (self facingMe:) (CueObj changeState: 3))
				)
			)
		)
		(return (pEvent claimed?))
	)
	
	(method (doVerb theVerb &tmp temp0 temp1)
		(= temp0 (if gEcoDoVerbCode else dftDoVerb))
		(if (== modNum -1) (= modNum gNumber))
		(if
		(and global90 (Message msgGET modNum noun theVerb 0 1))
			(global91 say: noun theVerb 0 0 0 modNum)
		else
			(temp0 doit: theVerb self)
		)
	)
	
	(method (notFacing &tmp temp0)
		(gEgo setMotion: 0)
		(CueObj client: self state: 0 cycles: 0 cue:)
	)
	
	(method (facingMe theTheGEgo &tmp theGEgo temp1)
		(cond 
			(argc (= theGEgo theTheGEgo))
			((gCast contains: gEgo) (= theGEgo gEgo))
			(else (return 1))
		)
		(if
			(>
				(= temp1
					(Abs
						(-
							(GetAngle (theGEgo x?) (theGEgo y?) x y)
							(theGEgo heading?)
						)
					)
				)
				180
			)
			(= temp1 (- 360 temp1))
		)
		(return
			(if (<= temp1 sightAngle)
				(return 1)
			else
				(if (!= sightAngle 26505) (self notFacing:))
				(return 0)
			)
		)
	)
	
	(method (isNotHidden)
		(return 1)
	)
	
	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x?))
			(= temp1 (param1 y?))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(cond 
				((IsObject onMeCheck) (AvoidPath temp0 temp1 onMeCheck))
				(
					(or
						(not (if (or nsLeft nsRight nsTop) else nsBottom))
						(and
							(<= nsLeft temp0)
							(<= temp0 nsRight)
							(<= nsTop temp1)
							(<= temp1 nsBottom)
						)
					)
					(if (!= onMeCheck 26505)
						(& onMeCheck (OnControl 4 temp0 temp1))
					else
						1
					)
				)
			)
		)
	)
	
	(method (approachVerbs param1 &tmp temp0 temp1)
		(= _approachVerbs 0)
		(if (and argc gEcoApproachCode [param1 0])
			(= temp0 0)
			(while (< temp0 argc)
				(= temp1 (gEcoApproachCode doit: [param1 temp0]))
				(self _approachVerbs: (| (self _approachVerbs?) temp1))
				(++ temp0)
			)
		)
	)
)

(instance dftDoVerb of Code
	(properties)
	
	(method (doit)
		(return 1)
	)
)

(class Actions of Code
	(properties)
	
	(method (doVerb)
		(return 0)
	)
)
